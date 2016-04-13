package com.sagasu.playground;


import java.io.File;
import java.io.FileFilter;

public class MyFileFilter {
    public static void main(String[] args){
        // typical impelentation of interface by using anonymous class
        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };


        // Implementing interface by using lambda.
        FileFilter ff2 = (File file) -> file.getName().endsWith(".java");

        //A functional interface is an interface that has just one abstract method, and thus represents a single function contract.
        //If an interface has more than one method (it is not a funcitonal interface) and can not be implemented thru lambda.
    }
}
