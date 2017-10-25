package com.sagasu.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTests {
    @Test
    public void Test_BuildTree_TreeNotNull(){
        BinaryTree bt = new BinaryTree();

        bt.Build(new int[]{1,2,3,4,5});

        Assert.assertEquals(2, bt.Get(2));

    }
}
