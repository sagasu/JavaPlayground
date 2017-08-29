package com.sagasu.optionals;

import java.util.Optional;

/**
 * Created by foo on 29/08/2017.
 */
public class Optionals {
    public Optional<String> findFoo(String key){
        return null;
    }

    public void run(){
        findFoo("").orElse("");
        findFoo("").orElseThrow(RuntimeException::new);
    }
}
