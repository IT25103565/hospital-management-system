package com.example.hospital_management_system.base;

public abstract class Person {
    private String id;
    private String name;

    public Person() {}

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Encapsulation: Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Abstraction & Polymorphism setup
    public abstract String getRoleDetails();
}
