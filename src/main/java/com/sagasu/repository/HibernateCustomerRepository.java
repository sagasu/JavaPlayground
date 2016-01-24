package com.sagasu.repository;

import com.sagasu.model.Customer;

import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public interface HibernateCustomerRepository {
    List<Customer> findAll();
}
