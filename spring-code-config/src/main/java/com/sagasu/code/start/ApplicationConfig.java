package com.sagasu.code.start;

import com.sagasu.code.repository.CustomerRepository;
import com.sagasu.code.repository.HibernateCustomerRepositoryImpl;
import com.sagasu.code.service.CustomerService;
import com.sagasu.code.service.HibernateCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"com.sagasu.code"})
public class ApplicationConfig {
    @Bean(name = "customerService")
//    @Scope("singleton")
    public CustomerService getCustomerService(){
        //Having ComponentScan is probably the only reasonable option, so you don't need to do everything manually.

        HibernateCustomerServiceImpl hibernateCustomerService = new HibernateCustomerServiceImpl();

         //new HibernateCustomerServiceImpl(getCustomerRepository());
//      hibernateCustomerService.setCustomerRepository(getCustomerRepository());
        return hibernateCustomerService;
    }

    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository(){
        return new HibernateCustomerRepositoryImpl();
    }
}
