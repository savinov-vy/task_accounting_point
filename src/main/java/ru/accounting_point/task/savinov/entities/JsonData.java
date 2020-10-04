package ru.accounting_point.task.savinov.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.*;


public class JsonData implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    public JsonData() {
    }

    public JsonData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

