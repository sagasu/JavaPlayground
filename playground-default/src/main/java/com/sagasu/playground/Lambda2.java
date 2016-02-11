package com.sagasu.playground;

import java.util.function.Predicate;

/**
 * Created by foo on 26/10/2015.
 */
public class Lambda2 {
  public boolean Foo(){
      Predicate<Person> olderThanTwo = p -> p.age >= 2;

      doSometihg(23, olderThanTwo);

      return true;
  }

    private void doSometihg(int i, Predicate<Person> olderThanTwo) {

    }
}

