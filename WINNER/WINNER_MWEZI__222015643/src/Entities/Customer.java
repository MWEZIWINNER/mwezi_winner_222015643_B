package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {//	Customer_id	First_name	Last_name	Age	Phone_number	Creditcard_id
	private int cstid;
	private String fname;
	private String lname;
	private String age;
	private String phone;
	private String crdtid;
	public Customer() {
	    // Default constructor
	}
	public Customer(int cstid,String fname,String lname,String age,String phone,String crdtid) {
		super();
		this.cstid=cstid;
		this.fname=fname;
		this.lname=lname;
		this.age=age;
		this.phone=phone;
		this.crdtid=crdtid;
	}
	
	public int getCstid() {
		return cstid;
	}
	public void setCstid(int cstid) {
		this.cstid = cstid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCrdtid() {
		return crdtid;
	}
	public void setCrdtid(String crdtid) {
		this.crdtid = crdtid;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/mwezi_winner_opsms";
	    String user = "222015643";
	    String password = "222015643";

	    // SQL query to insert data
	    String sql = "INSERT INTO customer (First_name,	Last_name,	Age,	Phone_number,	Creditcard_id) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.fname);
	       preparedStatement.setString(2, this.lname);
	       preparedStatement.setString(3, this.age);
	       preparedStatement.setString(4, this.phone);
	       preparedStatement.setString(5, this.crdtid);
	     
	        
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

        String sql = "SELECT * FROM customer";

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
	    String sql = "UPDATE customer SET First_name=?,	Last_name=?,	Age=?,	Phone_number=?,	Creditcard_id=?  WHERE Customer_id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFname());
	          stm.setString(2, this.getLname());
	          stm.setString(3, this.getAge());
	          stm.setString(4, this.getPhone());
	          stm.setString(5, this.getCrdtid()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(6, inputstid);
	         
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
	    String sql = "DELETE FROM customer WHERE Customer_id= ?";

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







