package com.example.school_service.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String directorName;

    // 🏗️ Constructeurs
    public School() {}

    public School(Long id, String name, String address, String directorName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.directorName = directorName;
    }

    // 📌 Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}