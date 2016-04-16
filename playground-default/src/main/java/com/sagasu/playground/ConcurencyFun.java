package com.sagasu.playground;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurencyFun {
    public static void main(String[] args) {
        OldSchoolWayOfConcurrency();
    }

    // Using Future introduced in java 5
    private static void OldSchoolWayOfConcurrency() {
        String stockInfo = null;
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<String> future = pool.submit(() -> getStockInfo("AMZ"));
        try{
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
