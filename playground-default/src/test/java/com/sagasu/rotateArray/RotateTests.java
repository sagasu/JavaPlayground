package com.sagasu.rotateArray;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotateTests {
    @Test
    public void rotate(){
        MyRotate r = new MyRotate();
        int[] ar = {1,2,3,4,5};
        r.rotate(ar, 3);
        System.out.println(Arrays.toString(ar));
        Assert.assertArrayEquals(new int[]{3,4,5,1,2}, ar);
    }
}
