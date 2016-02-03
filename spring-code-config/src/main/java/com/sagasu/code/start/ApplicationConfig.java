package com.sagasu.code.start;

import com.sagasu.code.repository.CustomerRepository;
import com.sagasu.code.repository.HibernateCustomerRepositoryImpl;
import com.sagasu.code.service.CustomerService;
import com.sagasu.code.service.HibernateCustomerServiceImpl;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"com.sagasu.code"})
@PropertySource("classpath:app.properties")
public class ApplicationConfig {

    @Bean
    public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer(){
        return new PropertyPlaceholderConfigurer();
    }

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
