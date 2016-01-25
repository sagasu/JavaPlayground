package com.sagasu.playground;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by mateusz.kopij on 25/01/2016.
 */
public class LambdasTests {

    @Test
    public void add_TwoNumbers_ReturnSum(){
        Lambdas lambdas = new Lambdas();
        int sum = lambdas.add(1,2);

        Assert.assertEquals(3, sum);
    }
}
