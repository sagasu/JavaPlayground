package com.sagasu.service;

import com.sagasu.model.Customer;
import com.sagasu.repository.HibernateCustomerRepository;
import com.sagasu.repository.HibernateCustomerRepositoryImpl;

import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public class HibernateCustomerServiceImpl implements HibernateCustomerService {
    private HibernateCustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();

    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
