package com.sagasu.playground;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by mateusz.kopij on 25/01/2016.
 */
public class TypeInferencePlaygroundTests {

    @Test
    public void checkCasting_SingleCharacter_ReturnThatCharacter(){
        TypeInferencePlayground tip = new TypeInferencePlayground();
        List result = tip.checkCasting("A");

        Assert.assertEquals("A", result.get(0));
    }
}
