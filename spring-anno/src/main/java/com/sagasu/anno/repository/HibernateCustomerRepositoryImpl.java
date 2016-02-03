package com.sagasu.anno.repository;


import com.sagasu.anno.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Value("${someProperty}")
    private String someValue;

    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<Customer>();

        Customer cus = new Customer();
        cus.setFirstName(someValue);
        customers.add(cus);

        return customers;
    }
}
