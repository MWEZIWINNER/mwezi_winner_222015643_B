package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Portrait {//Portrait_id	Artist_id	Warehouse_id	Portrait_name	Portrait_cost
	private int prtrid;
	private String artid;
	private String warehsid;
	private String prtrname;
	private String prtrcost;
	
	public Portrait() {
	    // Default constructor
	}
	public Portrait(int prtrid,String artid,String warehsid,String prtrname,String prtrcost) {
		super();
		this.prtrid=prtrid;
		this.artid=artid;
		this.warehsid=warehsid;
		this.prtrname=prtrname;
		this.prtrcost=prtrcost;
	}
	public int getPrtrid() {
		return prtrid;
	}
	public void setPrtrid(int prtrid) {
		this.prtrid = prtrid;
	}
	public String getArtid() {
		return artid;
	}
	public void setArtid(String artid) {
		this.artid = artid;
	}
	public String getWarehsid() {
		return warehsid;
	}
	public void setWarehsid(String warehsid) {
		this.warehsid = warehsid;
	}
	public String getPrtrname() {
		return prtrname;
	}
	public void setPrtrname(String prtrname) {
		this.prtrname = prtrname;
	}
	public String getPrtrcost() {
		return prtrcost;
	}
	public void setPrtrcost(String prtrcost) {
		this.prtrcost = prtrcost;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/mwezi_winner_opsms";
	    String user = "222015643";
	    String password = "222015643";

	    // SQL query to insert data
	    String sql = "INSERT INTO portrait (Artist_id,	Warehouse_id,	Portrait_name,	Portrait_cost) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.artid);
	       preparedStatement.setString(2, this.warehsid);
	       preparedStatement.setString(3, this.prtrname);
	       preparedStatement.setString(4, this.prtrcost);
	       
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

        String sql = "SELECT * FROM portrait";

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
	    String sql = "UPDATE portrait SET Artist_id=?,	Warehouse_id=?,	Portrait_name=?,	Portrait_cost=? WHERE Portrait_id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getArtid());
	          stm.setString(2, this.getWarehsid());
	          stm.setString(3, this.getPrtrname());
	          stm.setString(4, this.getPrtrcost());
	           // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputstid);

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
	    String sql = "DELETE FROM portrait WHERE  Portrait_id= ?";

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







