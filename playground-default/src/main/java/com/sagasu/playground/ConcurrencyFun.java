package com.sagasu.playground;

import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcurrencyFun {
    public static void main(String[] args) {
        OldSchoolWayOfConcurrency();

        CompletableFutureConcurrency();

        CompletableFutureWithCompleteConcurrency();
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
