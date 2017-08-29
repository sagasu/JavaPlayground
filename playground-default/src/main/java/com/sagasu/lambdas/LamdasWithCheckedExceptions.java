package com.sagasu.lambdas;

import java.util.function.Function;

/**
 * Created by foo on 29/08/2017.
 */
public class LamdasWithCheckedExceptions {
    public Function<String, Class> load(){
        // It will throw unhandled exception; class not found exception
        // It is because it is checked exception and it needs to be handled here.
        //return className -> Class.forName(className);


        // not important, just to do something, the code above is important
        return new Function<String, Class>() {
            @Override
            public Class apply(String s) {
                return null;
            }
        };
    }
}
