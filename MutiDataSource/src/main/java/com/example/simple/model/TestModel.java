package com.example.simple.model;

public class TestModel {
    private int age;
    private long name;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(long name) {
        this.name = name;
    }

    public long getName() {
        return name;
    }

    @Override
    public String toString() {
        return getAge() + " " + getName();
    }
}
