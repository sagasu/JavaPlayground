package com.sagasu.playground;

import java.util.stream.IntStream;

public class PrimeFun {

    public static void main(String[] args){
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));

        System.out.println(isPrime2(1));
        System.out.println(isPrime2(2));
        System.out.println(isPrime2(3));
        System.out.println(isPrime2(4));
    }

    private static boolean isPrime(final int number){
        for(int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }

        return number > 1;
    }

    private static boolean isPrime2(final int number){
        // java 8 streams
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }
}
