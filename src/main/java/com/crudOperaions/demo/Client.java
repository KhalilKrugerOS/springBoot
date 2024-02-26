package com.crudOperaions.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private  int age;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
