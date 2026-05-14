package com.example.hospital_management_system;

import com.example.hospital_management_system.base.Person; // Imports your base class!

public class Doctor extends Person {
    private String specialization;
    private int experienceYears;

    public Doctor() {}

    public Doctor(String id, String name, String specialization, int experienceYears) {
        super(id, name); // Inheritance from Person
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    // Encapsulation
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    // Polymorphism: Overriding the abstract method
    @Override
    public String getRoleDetails() {
        return "Doctor specialized in " + specialization;
    }

    // Prepare data for the text file
    @Override
    public String toString() {
        return getId() + "," + getName() + "," + specialization + "," + experienceYears;
    }
}