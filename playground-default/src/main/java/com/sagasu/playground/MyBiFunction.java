package com.sagasu.playground;

import java.util.function.BiFunction;

public class MyBiFunction {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatFunction = (s, t) -> {
            return s + t;
        };
        System.out.println(concatFunction.apply("hell","o"));


        concatFunction = MyBiFunction::concatString;
        System.out.println(concatFunction.apply("he","llo2"));

        MyBiFunction instance = new MyBiFunction();
        // first class citizen
        concatFunction = instance::concatString2;
        System.out.println(concatFunction.apply("hello"," w"));

    }

    private static String concatString(String a, String b){
        return a+b;
    }

    String concatString2(String a, String b){
        return a+b;
    }
}
