package com.sagasu.playground;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by mateusz.kopij on 25/01/2016.
 */
public class Lambda2Tests {

    @Test
    public void add_TwoNumbers_ReturnSum(){
        Lambda2 lambda = new Lambda2();
        boolean status = lambda.Foo();

        Assert.assertTrue(status);
    }
}
