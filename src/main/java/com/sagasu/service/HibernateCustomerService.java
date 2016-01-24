package com.sagasu.service;

import com.sagasu.model.Customer;

import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public interface HibernateCustomerService {
    List<Customer> findAll();
}
