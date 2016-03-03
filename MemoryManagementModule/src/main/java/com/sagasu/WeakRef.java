package com.sagasu;

import java.lang.ref.WeakReference;

public class WeakRef {
    public static void main(String[] args){
        Person person = new Person();
        WeakReference<Person> wr = new WeakReference<Person>(person);

        // Strong reference is returned
        Person p1 = wr.get();
        System.out.println(p1);

        person = null;
        p1=  null;

        // works because GC didn't run yet
        Person p2 = wr.get();
        System.out.println(p2);

        p2 = null;
        System.gc();

        // after gc runs weak ref is destroyed so null is returned.
        Person p3 = wr.get();
        System.out.println(p3);
    }
}

class Person{}