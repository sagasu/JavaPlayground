package com.sagasu.service;

import com.sagasu.model.Customer;
import com.sagasu.repository.HibernateCustomerRepository;

import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public class HibernateCustomerServiceImpl implements HibernateCustomerService {

    public HibernateCustomerServiceImpl(HibernateCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setCustomerRepository(HibernateCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private HibernateCustomerRepository customerRepository;// = new HibernateCustomerRepositoryImpl();

    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
