package com.revature.utility;

import org.postgresql.Driver; // Maven dependency

import java.sql.Connection; // JDBC interface
import java.sql.DriverManager; // JDBC class
import java.sql.SQLException;

public class ConnectionUtility {

    public static Connection getConnection() throws SQLException {
        String connectionString = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres"; // Normally this info will be in environment variables
        String password = "password"; // System.getenv("db_username");
        // You can also use a configuration file (that will not be pushed to Github)

        DriverManager.registerDriver(new Driver());

        Connection con = DriverManager.getConnection(connectionString, username, password);

        return con;
    }

}
