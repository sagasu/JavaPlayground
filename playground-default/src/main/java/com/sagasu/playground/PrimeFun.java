package com.sagasu.playground;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrimeFun {

    public static void main(String[] args){
        IntStream.range(1,5).forEach(value -> System.out.println(isPrime(value)));
        IntStream.range(1,5).forEach(value -> System.out.println(isPrime2(value)));
        IntStream.range(1,5).forEach(value -> System.out.println(isPrime3(value)));

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

    private static boolean isPrime3(final int number) {
        Predicate<Integer> isDivisible = divisor -> number % divisor == 0;

        return number > 1 && IntStream.range(2, number).noneMatch(index -> isDivisible.test(index));
    }
}
