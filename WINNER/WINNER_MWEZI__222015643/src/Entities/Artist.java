package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Artist {//Artist_id	Names	Age	Gender	Nationality	Experience
	private int artid;
	private String name;
	private String age;
	private String gender;
	private String nationlty;
	private String exprnce;
	public Artist() {
	    // Default constructor
	}
	public Artist(int artid,String name,String age,String gender, String nationlty,String exprnce) {
		super();
		this.artid=artid;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.nationlty=nationlty;
		this.exprnce=exprnce;
	}
	
	public int getArtid() {
		return artid;
	}
	public void setArtid(int artid) {
		this.artid = artid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationlty() {
		return nationlty;
	}
	public void setNationlty(String nationlty) {
		this.nationlty = nationlty;
	}
	public String getExprnce() {
		return exprnce;
	}
	public void setExprnce(String exprnce) {
		this.exprnce = exprnce;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/mwezi_winner_opsms";
	    String user = "222015643";
	    String password = "222015643";

	    // SQL query to insert data
	    String sql = "INSERT INTO artist (Names,	Age,	Gender,	Nationality,	Experience) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.name);
	       preparedStatement.setString(2, this.age);
	       preparedStatement.setString(3, this.gender);
	       preparedStatement.setString(4, this.nationlty);
	       preparedStatement.setString(5, this.exprnce);
	     
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

        String sql = "SELECT * FROM artist";

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
	    String sql = "UPDATE artist SET Names=?,	Age=?,	Gender=?,	Nationality=?,	Experience=? WHERE Artist_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getName());
	          stm.setString(2, this.getAge());
	          stm.setString(3, this.getGender());
	          stm.setString(4, this.getNationlty());
	          stm.setString(5, this.getExprnce()); // Assuming there is a column named 'id' for the WHERE clause
	       
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
	    String sql = "DELETE FROM artist WHERE  Artist_id	= ?";

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






