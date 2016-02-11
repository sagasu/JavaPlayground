package com.sagasu.repository;

import com.sagasu.model.Customer;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public class HibernateCustomerRepositoryImpl implements HibernateCustomerRepository {

    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<Customer>();

        Customer cus = new Customer();
        cus.setFirstName("Matt");
        customers.add(cus);

        return customers;
    }
}
