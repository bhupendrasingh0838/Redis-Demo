package com.example.Redis.demo.Entity;

import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private String fees;

    public Student() {
    }

    public Student(int id, String name, String fees) {
        this.id = id;
        this.name = name;
        this.fees = fees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }
}
