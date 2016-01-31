package com.sagasu.anno.service;



import com.sagasu.anno.model.Customer;

import java.util.List;

/**
 * Created by foo on 24/01/2016.
 */
public interface HibernateCustomerService {
    List<Customer> findAll();
}
