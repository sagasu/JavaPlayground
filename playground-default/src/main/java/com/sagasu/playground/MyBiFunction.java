package com.sagasu.playground;

import java.util.function.BiFunction;

public class MyBiFunction {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatFunction = (s, t) -> {
            return s + t;
        };
        System.out.println(concatFunction.apply("hell","o"));
    }
}
