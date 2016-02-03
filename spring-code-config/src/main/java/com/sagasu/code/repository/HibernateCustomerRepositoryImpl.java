package com.sagasu.code.repository;


import com.sagasu.code.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Value("${someValue:}")
    public String name;

    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<Customer>();

        Customer cus = new Customer();
        cus.setFirstName(name);
        customers.add(cus);

        return customers;
    }
}
