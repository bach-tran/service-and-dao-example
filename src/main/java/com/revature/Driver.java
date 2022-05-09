package com.revature;

import com.revature.dao.CustomerDAO;
import com.revature.model.Customer;
import com.revature.service.CustomerService;

import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) {
        CustomerService cs = new CustomerService();

        Customer c = new Customer(0, "Dan", "Felleman", "dan_felleman@email.com", 500);
        try {
            System.out.println(cs.addCustomer(c));
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
