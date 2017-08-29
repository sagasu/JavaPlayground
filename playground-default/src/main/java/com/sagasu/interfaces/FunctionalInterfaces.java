package com.sagasu.interfaces;


import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public void run(){
        FIRunnable runn = new FIRunnable();
        Thread t = new Thread(runn);


    }
}

class FIRunnable implements Runnable {
    public void run(){

    }
}

class FICallable implements Callable{
    public Integer call(){
        return 1;
    }
}

class FIFunction implements Function<String,Integer>{
    public Integer apply(String a){
        return 1;
    }
}

class FIPredicate implements Predicate<String> {
    public boolean test(String a){
        return true;
    }
}

class FISupplier implements Supplier<String> {
    public String get(){
        return "";
    }
}

class FIConsumer implements Consumer<String> {
    public void accept(String a){

    }
}