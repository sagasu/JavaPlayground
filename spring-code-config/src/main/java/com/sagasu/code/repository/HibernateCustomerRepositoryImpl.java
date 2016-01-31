package com.sagasu.code.repository;


import com.sagasu.code.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<Customer>();

        Customer cus = new Customer();
        cus.setFirstName("Matt class config");
        customers.add(cus);

        return customers;
    }
}
