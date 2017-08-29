package com.sagasu.playground;

import javafx.beans.property.ReadOnlyObjectWrapper;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;

public class MyRxFun {
    public static void main(String[] args) {
        Observable<Integer> observable = null;

//        observable = new ReadOnlyObjectWrapper<Integer>(42);
//                //Observable.from(Integer.valueOf(42).asObject());
//        observable.subscribe((i) -> {
//            System.out.println(i);
//        });

        System.out.println(Thread.currentThread().getName());
        observable = Observable.from(generateFibonacciList());
        observable.subscribe(
                //onNext
                (i) -> {System.out.println(Thread.currentThread().getName() + " "+  i);},
                //onError
                (i) -> System.out.println("error"),
                //onCompleted
                () -> System.out.println("Finished printing fibonnaci"));




        observable = Observable.from(generateFibonacciList());
        // This will now run on a different thread
        observable.subscribeOn(Schedulers.newThread()).subscribe(
                //onNext
                (i) -> { System.out.println(Thread.currentThread().getName() + " "+  i); },
                //onError
                (i) -> System.out.println("error on different thread."),
                //onCompleted
                () -> System.out.println("Finished printing fibonnaci on a different thread"));observable = Observable.from(generateFibonacciList());



        // Observable.parallel was removed because almost always it was doing something that people did not expected it to do:
        // https://github.com/ReactiveX/RxJava/pull/1716
        // https://github.com/ReactiveX/RxJava/issues/1673



        // This will now run on a different thread
        observable.observeOn(Schedulers.io()).subscribe(
                //onNext
                (i) -> { System.out.println(Thread.currentThread().getName() + " "+  i); },
                //onError
                (i) -> System.out.println("error in observe on."),
                //onCompleted
                () -> System.out.println("Finished printing fibonnaci with observe on"));


        Observable<List<Integer>> observableFuture = null;
        FutureTask<List<Integer>> future = new FutureTask<List<Integer>>(() -> {
            // This runs on a different thread.
            System.out.println("This is on a different thread:" + Thread.currentThread().getName());
            return generateFibonacciList();
        });

        observableFuture = Observable.from(future);
        Schedulers.computation().createWorker().schedule(() -> future.run());

        observableFuture.subscribe((list) -> {
            list.forEach((i) -> {
                System.out.println(Thread.currentThread().getName() + " "+  i);
            });
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
