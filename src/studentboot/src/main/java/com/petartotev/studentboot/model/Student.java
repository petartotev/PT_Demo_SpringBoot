package com.petartotev.studentboot.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Student {
    private Long id;
    @NotBlank(message = "First Name cannot be blank")
    @Size(max = 50, message = "First Name must be less than 50 characters")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    @Size(max = 50, message = "Last Name must be less than 50 characters")
    private String lastName;
    @NotNull(message = "Age is required")
    private int age;
    private LocalDate dateOfBirth;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
}