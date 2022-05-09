package com.revature.service;

import com.revature.dao.CustomerDAO;
import com.revature.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDAO();
    }

    public List<Customer> getAllCustomers() throws SQLException {
        return customerDao.getAllCustomers();
    }

    public Customer addCustomer(Customer c) throws Exception {
        // Business logic
        // 1. Check if age is negative
        // 2. Check if email is invalid
        // etc...
        if (c.getAge() < 0) {
            throw new Exception("Age of Customer cannot be negative");
        }

        if (!c.getEmail().matches("^(.+)@(.+)$")) {
            throw new Exception("Email must follow the format xxx@xxx.xxx");
        }

        // If you have reached this point, you are guaranteed to have an age that is NOT negative
        return customerDao.addCustomer(c);
    }

}
