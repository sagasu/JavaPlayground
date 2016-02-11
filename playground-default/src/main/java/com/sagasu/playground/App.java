package com.sagasu.playground;

import com.sagasu.service.HibernateCustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HibernateCustomerService customerService = ac.getBean("customerService", HibernateCustomerService.class);

        System.out.println( "Hello World!" );
        //HibernateCustomerService customerService = new HibernateCustomerServiceImpl();
        System.out.println(customerService.findAll().get(0).getFirstName());
    }
}
