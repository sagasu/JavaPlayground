package com.sagasu.playground;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mateusz.kopij on 26/01/2016.
 */
public class TypeInferencePlayground {
    public void checkCasting(){
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.addAll(Arrays.<String>asList());
    }
}
