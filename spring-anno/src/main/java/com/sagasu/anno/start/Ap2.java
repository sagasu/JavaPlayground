package com.sagasu.anno.start;

import com.sagasu.anno.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ap2 {
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = ac.getBean("customerService", CustomerService.class);

        System.out.println( "Hello World!" );

        System.out.println(customerService.findAll().get(0).getFirstName());
    }}
