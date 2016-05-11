package com.sagasu.playground;

import javafx.beans.property.ReadOnlyObjectWrapper;
import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRxFun {
    public static void main(String[] args) {
        Observable<Integer> observable = null;

//        observable = new ReadOnlyObjectWrapper<Integer>(42);
//                //Observable.from(Integer.valueOf(42).asObject());
//        observable.subscribe((i) -> {
//            System.out.println(i);
//        });

        observable = Observable.from(generateFibonacciList());
        observable.subscribe((i) -> {
            System.out.println(i);
        });

    }

    public static List<Integer> generateFibonacciList(){
        // I hate lack of syntactic sugar for array lists :(
        // http://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
        ArrayList<Integer> fib =  new ArrayList<Integer>();
        fib.add(1);
        fib.add(2);
        fib.add(3);
        fib.add(5);
        fib.add(8);
        fib.add(13);
        fib.add(21);
        fib.add(34);
        return fib;
    }
}
