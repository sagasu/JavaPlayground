package com.sagasu;

import java.util.Random;

// This runs as java process, you can fire up showJstatInfo.bat while it is running.
// jps command will print currently running java aps. But if you run it from IDE then it's java process.
public class AllocationOverwrite {
    public static void main(String... args){
        int arraySize = 1000000;
        GCMe[] gcmes = new GCMe[arraySize];

        int count = 0;
        Random rnd = new Random();
        while (true){
            gcmes[rnd.nextInt(arraySize)] = new GCMe();
            if(count % 1000000 == 0){
                System.out.println(".");
            }
            count++;
        }
    }
}
