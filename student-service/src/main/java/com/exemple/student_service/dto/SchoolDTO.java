package com.exemple.student_service.dto;


public class SchoolDTO {
    private Long id;
    private String name;
    private String address;
    private String directorName;

    public SchoolDTO() {
    }

    public SchoolDTO(Long id, String name, String address, String directorName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.directorName = directorName;
    }

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

    @Override
    public String toString() {
        return "SchoolDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}