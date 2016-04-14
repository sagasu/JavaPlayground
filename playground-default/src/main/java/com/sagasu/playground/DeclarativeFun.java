package com.sagasu.playground;


import java.util.Arrays;
import java.util.List;

public class DeclarativeFun {
    public static void main(String[] args){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        // ugly like ... terrible
        int total = 0;
        for (int e : values) {
            total += e * 2;
        }
        System.out.println(total);


        // so much better, and no mutation :)
        System.out.println(values.stream()
                .map(e -> e * 2)
                .reduce(0, (c,e) -> c + e));
    }
}
