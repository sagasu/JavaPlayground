package com.sagasu.anno.model;

/**
 * Created by foo on 24/01/2016.
 */
public class Customer {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String lastName;
}
