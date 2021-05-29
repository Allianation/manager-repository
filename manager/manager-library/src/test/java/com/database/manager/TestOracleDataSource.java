
package com.database.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestOracleDataSource {
	
	public static void getData() {
        final String SQL_QUERY = "SELECT * FROM users";
        // Open a connection
        try (Connection con = OracleDataSource.getConnection("digital", "password", "ORCLCDB", "localhost" ,1521); PreparedStatement pst = con.prepareStatement(SQL_QUERY); ResultSet rs = pst.executeQuery();) {
        	// Extract data from result set
        	while (rs.next()) {
        		// Retrieve by column name
                System.out.print("First Name: " + rs.getString("first_name"));
                System.out.print(", Last Name: " + rs.getString("last_name"));
                System.out.print(", Email: " + rs.getString("email"));
                System.out.println(", User Status: " + rs.getString("id_user_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		getData();
	}

}
