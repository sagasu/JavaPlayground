package com.sagasu.playground;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeFun {

    public static void main(String[] args){
        IntStream.range(1,5).forEach(value -> System.out.println(isPrime(value)));
        IntStream.range(1,5).forEach(value -> System.out.println(isPrime2(value)));
        IntStream.range(1,5).forEach(value -> System.out.println(isPrime3(value)));

        doubleOffirstEvenGreaterThanThree();
        doubleOffirstEvenGreaterThanThree2();
        doubleOffirstEvenGreaterThanThree3();
        doubleOffirstEvenGreaterThanThree4();

        System.out.println(calculateValue());
        slowDouble();
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

    // find the double of the first even number greater than 3
    private static void doubleOffirstEvenGreaterThanThree(){
        // nice cast from array to list
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int result = 0;
        for(int e: values){
            if(e > 3 && e % 2 == 0){
                result = e * 2;
                break;
            }
        }
        System.out.println(result);
    }

    private static void doubleOffirstEvenGreaterThanThree2(){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // sout shortcut converts to System.out.println
        System.out.println(
        values.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .get());
    }

    public static boolean isGreaterThan3(final int number){
        System.out.println("isGreaterThan3 " + number);
        return number > 3;
    }

    public static boolean isEven(final int number){
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number){
        System.out.println("doubleIt " + number);
        return number * 2;
    }

    private static void doubleOffirstEvenGreaterThanThree3(){
        // notice that I changed order 4 and 5 to see lazynes
        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);

        // lazy & composition - I added sout statements to see that streams are lazy in calls.
        Stream<Integer> sti =  values.stream()
                // I love this way of spec method
                .filter(PrimeFun::isGreaterThan3)
                // Is this a higher order function then, because I am passing a function to a function.
                .filter(PrimeFun::isEven)
                .map(PrimeFun::doubleIt);
        System.out.println(sti.findFirst());
    }

    private static void doubleOffirstEvenGreaterThanThree4(){
        // notice that I changed order 4 and 5 to see lazynes
        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);
        Predicate<Integer> isGT3 = value -> value > 3;

        Function<Integer, Predicate<Integer>> isGT = pivot -> number -> number > pivot;

        Stream<Integer> sti =  values.stream()
                .filter(isGT.apply(3))
                .filter(PrimeFun::isEven)
                .map(PrimeFun::doubleIt);
        System.out.println(sti.findFirst());
    }

    private static int calculateValue(){
        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);

        return totalValues(values, e -> true);
    }

    private static int totalValues(List<Integer> numbers, Selector selector){
        int result = 0;
        for(int e: numbers){
            if(selector.pick(e)) result += e;
        }
        return result;
    }

    private static int totalValues2(List<Integer> numbers, Predicate<Integer> selector){
        return numbers.stream()
                .filter(selector)
                .reduce(0, Math::addExact);
    }

    private static int slowDoubleIt(int number){
        try{Thread.sleep(1000);} catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * 2;
    }

    private static void slowDouble(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        // referential transparency

        System.out.println(
                // Much faster parallel when method executed is very slow
                numbers.parallelStream()
                    .mapToInt(PrimeFun::slowDoubleIt)
                    .sum()
        );
    }

    interface Selector{
        public boolean pick(int value);
    }

    class EvenSelector implements Selector{
        @Override
        public boolean pick(final int value){
            return value % 2 == 0;
        }
    }
}
