package com.revature.dao;

import com.revature.model.Customer;
import com.revature.utility.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO { // Purpose of CustomerDAO is to perform crud operations on Customer information

    public List<Customer> getAllCustomers() throws SQLException {

        // try-with-resources: it will automatically call con.close() when the block of code is done executing
        try(Connection con = ConnectionUtility.getConnection()) {
            List<Customer> customers = new ArrayList<>();

            String sql = "SELECT * FROM customer";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            // Iterate over each record coming back from the query
            while (rs.next()) {
                // Create new Customer object
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                Customer c = new Customer(id, firstName, lastName, email, age);

                // Add Customer to the List
                customers.add(c);
            }

            return customers;
        }
    }

    public Customer addCustomer(Customer customer) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection()) {
            String sql = "INSERT INTO customer (first_name, last_name, email, age) " +
                    "VALUES " +
                    "(?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setInt(4, customer.getAge());

            pstmt.executeUpdate(); // INSERT, UPDATE, DELETE

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt(1);

            return new Customer(generatedId, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                    customer.getAge());
        }
    }

}
