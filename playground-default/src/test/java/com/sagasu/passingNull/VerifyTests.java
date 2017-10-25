package com.sagasu.passingNull;

import org.junit.Assert;
import org.junit.Test;

public class VerifyTests {

    @Test
    public void verifyPassingNull_NullIsPassed_VariableIsSetInMethod(){
        Node node = null;
        Verify v = new Verify(node);

        Assert.assertNull(node);
    }
}
