package com.model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String password;

    // Constructor
    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}