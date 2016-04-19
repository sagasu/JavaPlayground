package com.sagasu.playground;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConcurrencyFun {
    public static void main(String[] args) {
        OldSchoolWayOfConcurrency();

        CompletableFutureConcurrency();

        CompletableFutureWithCompleteConcurrency();

        CompletableFutureWithThenApply();

        CompletableFutureRunAsync();

        CompletableFutureFluentFlow();
    }

    private static void CompletableFutureFluentFlow() {
        CompletableFuture cf1 = CompletableFuture
                .runAsync( ( ) -> {
                    System.out.println("executing CompletableFutureFluentFlow");
                    IntStream.range(1, 10).forEach(x -> System.out.println("CompletableFutureFluentFlow: " + x)); } )
                .whenComplete((x,y) -> System.out.println(x))
                .thenApply(x -> {System.out.println(x); return 10;})
                .thenAccept(x -> System.out.println(x))
                .thenRun(() -> System.out.println("almost there"));
    }

    private static void CompletableFutureRunAsync() {
        // runAsync doesn't return a value
        CompletableFuture cf1 = CompletableFuture.runAsync( ( ) -> {
            System.out.println("executing cf1");
            IntStream.range(1, 10).forEach(x -> System.out.println("cf: " + x));
        } );

    }

    private static void CompletableFutureWithThenApply() {
        CompletableFuture cf1 = CompletableFuture.supplyAsync( ( ) -> {
            System.out.println("executing cf1");
            IntStream.range(1, 10).forEach(x -> System.out.println("cf: " + x));
            return 10;
        } );

        // 'a' is a result from cf1 - in this case 10
        // thenApply is being executed immediately after cf1 finishes executing it's code - it means that as soon as results are ready execute theApply
        CompletableFuture cf2 = cf1.thenApply((a) -> {
            System.out.println("executing then aply with " + a);
            IntStream.range(1, 10).forEach(x -> System.out.println("thenApply: " + x));
            return "this is result of cf1";
        } );

        // 'a' is a result from cf1 - in this case "this is result of cf1"
        CompletableFuture cf3 = cf2.thenApply((a) -> {
            System.out.println("executing second then apply with: " + a);
            IntStream.range(1, 10).forEach(x -> System.out.println("second thenApply: " + x));
            return "this is result of cf2";
        } );
    }

    private static void CompletableFutureWithCompleteConcurrency() {

        CompletableFuture cflong = CompletableFuture.supplyAsync( ( ) -> {
            System.out.println("executing cflong");
            IntStream.range(1, 10).forEach(x -> System.out.println("get will wait again for results: " + x));
            return 10;
        } );


        CompletableFuture completor = CompletableFuture.supplyAsync(() -> {
            System.out.println("executing completor");
            cflong.complete(222);
            return 10;
        });

        try {
            System.out.println("get will wait again for results: " + cflong.get());
            System.out.println("get will wait again for results: " + completor.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void CompletableFutureConcurrency() {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            // this is long running task that returns some results.
            return "results ";
        });
        try {
            System.out.println("get will wait again for results: " + cf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> {
            // this is long running task that returns some results.
            return "results ";
        });
        // Notice that there is no need for try/catch
        System.out.println("getNow will try to get results, and if it they are not ready will return the fallback: " + cf.getNow("this is a fallback"));
    }

    // Using Future introduced in java 5
    private static void OldSchoolWayOfConcurrency() {
        String stockInfo = null;
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<String> future = pool.submit(() -> getStockInfo("AMZ"));
        try{
            // Wait for results from getStockInfo method
            stockInfo = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(stockInfo);
    }

    private static String getStockInfo(String amz) {
        return "apple";
    }
}
