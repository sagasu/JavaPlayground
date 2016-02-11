package com.sagasu.playground;

/**
 * Created by foo on 26/10/2015.
 */
public class Lambdas {
    //with type declaration
    MathOperation addition = (int a, int b) -> a + b;

    //with out type declaration
    MathOperation subtraction = (a, b) -> a - b;

    //with return statement along with curly braces
    MathOperation multiplication = (int a, int b) -> { return a * b; };

    //without return statement and without curly braces
    MathOperation division = (int a, int b) -> a / b;

    public int add(int a,int b){
        return addition.operation(a,b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
