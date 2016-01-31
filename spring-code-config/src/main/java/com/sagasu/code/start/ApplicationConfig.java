package com.sagasu.code.start;

import com.sagasu.code.repository.CustomerRepository;
import com.sagasu.code.repository.HibernateCustomerRepositoryImpl;
import com.sagasu.code.service.CustomerService;
import com.sagasu.code.service.HibernateCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean(name = "customerService")
    public CustomerService getCustomerService(){
        // I can't believe how stupid it is!
        HibernateCustomerServiceImpl hibernateCustomerService = new HibernateCustomerServiceImpl(getCustomerRepository());
//        hibernateCustomerService.setCustomerRepository(getCustomerRepository());
        return hibernateCustomerService;
    }

    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository(){
        return new HibernateCustomerRepositoryImpl();
    }
}
