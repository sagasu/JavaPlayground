package com.sagasu.playground;

import com.sagasu.service.HibernateCustomerService;
import com.sagasu.service.HibernateCustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        HibernateCustomerService customerService = new HibernateCustomerServiceImpl();
        System.out.println(customerService.findAll());
    }
}
