package com.sagasu.salary;


public class Employee {
    public float getSalary() {
        return salary;
    }


    public int getId() {
        return id;
    }


    public String getUser() {
        return user;
    }



    private int id;
    private String user;
    private float salary;

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
