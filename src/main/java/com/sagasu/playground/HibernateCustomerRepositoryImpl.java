package com.sagasu.playground;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public class HibernateCustomerRepositoryImpl {
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<Customer>();

        Customer cus = new Customer();
        cus.setFirstName("Matt");
        customers.add(cus);

        return customers;
    }
}
