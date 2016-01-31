package com.sagasu.anno.service;


import com.sagasu.anno.model.Customer;
import com.sagasu.anno.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class HibernateCustomerServiceImpl implements CustomerService {

//    public HibernateCustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    @Autowired
    private CustomerRepository customerRepository;// = new HibernateCustomerRepositoryImpl();

    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
