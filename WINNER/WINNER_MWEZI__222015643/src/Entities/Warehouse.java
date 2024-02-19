package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Warehouse {//Warehouse_id	Order_id	Location
	private int warehsid;
	private String ordid;
	private String loctn;
	
	public Warehouse() {
	    // Default constructor
	}
	public Warehouse(int warehsid,String ordid,String loctn) {
		super();
		this.warehsid=warehsid;
		this.ordid=ordid;
		this.loctn=loctn;
		}
	
	public int getWarehsid() {
		return warehsid;
	}
	public void setWarehsid(int warehsid) {
		this.warehsid = warehsid;
	}
	public String getOrdid() {
		return ordid;
	}
	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}
	public String getLoctn() {
		return loctn;
	}
	public void setLoctn(String loctn) {
		this.loctn = loctn;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/mwezi_winner_opsms";
	    String user = "222015643";
	    String password = "222015643";

	    // SQL query to insert data
	    String sql = "INSERT INTO warehouse (Order_id, Location) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.ordid);
	       preparedStatement.setString(2, this.loctn);
	      
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
	
    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/mwezi_winner_opsms";
        String user = "222015643";
        String password = "222015643";

        String sql = "SELECT * FROM warehouse";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputstid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/mwezi_winner_opsms";
	    String user = "222015643";
	    String password = "222015643";

	    // SQL query to update data
	    String sql = "UPDATE warehouse SET Order_id=?, Location=?  WHERE Warehouse_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getOrdid());
	          stm.setString(2, this.getLoctn());
	           // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(3, inputstid);
	      	
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputstid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/mwezi_winner_opsms";
	    String user = "222015643";
	    String password = "222015643";

	    // SQL query to delete data
	    String sql = "DELETE FROM warehouse WHERE Warehouse_id	= ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputstid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}







