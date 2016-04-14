package com.sagasu.playground;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class InternalExternalIterator {
    public static void main(String[] args){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        // external iterator - entire structure, and handling is outside of the collection
        for (int i = 0; i < values.size(); i++){
            System.out.println(values.get(i));
        }

        // still external iterator
        for (int e :values) {
            System.out.println(e);
        }

        // this is internal iterator, this is prior to java 8 it required providing class, which is stupid
        values.forEach(new Consumer<Integer>(){

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        // internal iterator with lambda to rescue but keeping the method (forEach) introduced prior to 8
        values.forEach((Integer value) -> System.out.println(value));

        // I am surprised to see that Java is finally capable to guess the type
        values.forEach(value -> System.out.println(value));

        // yup, finally using method reference
        values.forEach(System.out::println);
    }
}
