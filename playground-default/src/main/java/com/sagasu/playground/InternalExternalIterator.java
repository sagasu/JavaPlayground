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

        // this is internal iterator
        values.forEach(new Consumer<Integer>(){

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
