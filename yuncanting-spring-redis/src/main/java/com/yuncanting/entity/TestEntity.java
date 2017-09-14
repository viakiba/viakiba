package com.yuncanting.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author viakiba
 */
public class TestEntity implements Serializable {

    private String id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name"+name;
    }
}