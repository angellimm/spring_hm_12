package com.example.demo.model;

import java.util.Objects;

public class User {

    private int id;

    private  String name;

    private String LastName;


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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String group_name) {
        this.LastName = LastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, LastName);
    }
}
