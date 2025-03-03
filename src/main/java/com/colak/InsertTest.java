package com.colak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

    public static void main() {

        try (Connection conn = DriverManager.getConnection("jdbc:duckdb:");
             Statement stmt = conn.createStatement()) {

            // Create a table
            stmt.execute("CREATE TABLE users (id INT, name STRING)");

            // Insert data
            stmt.execute("INSERT INTO users VALUES (1, 'Alice'), (2, 'Bob')");

            // Query data
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
