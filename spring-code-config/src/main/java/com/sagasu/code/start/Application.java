package com.sagasu.code.start;

import com.sagasu.code.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main( String[] args )
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CustomerService customerService = ac.getBean("customerService", CustomerService.class);

        System.out.println( "Hello World!" );

        System.out.println(customerService.findAll().get(0).getFirstName());
    }}
