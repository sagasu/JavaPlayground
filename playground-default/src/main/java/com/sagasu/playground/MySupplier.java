package com.sagasu.playground;

import java.util.function.Function;
import java.util.function.Supplier;

public class MySupplier {
    public static void main(String[] args) {
        Supplier<String> xformOpperation = createCombineAndTransform("Hello", "World", (a) -> {
            return a.toUpperCase();
        });
        System.out.println(xformOpperation.get());
    }

    public static Supplier<String> createCombineAndTransform(String a, String b, Function<String,String> transformer){
        return () -> {
            String aa = a;
            String bb = b;
            if(transformer != null){
                aa = transformer.apply(a);
                bb = transformer.apply(b);
            }
            return aa + bb;
        };
    }
}
