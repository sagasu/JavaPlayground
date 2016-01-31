package com.sagasu.code.repository;



import com.sagasu.code.model.Customer;

import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public interface CustomerRepository {
    List<Customer> findAll();
}
