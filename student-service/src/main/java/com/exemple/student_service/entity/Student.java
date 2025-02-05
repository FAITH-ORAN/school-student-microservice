package com.exemple.student_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String name;
    private String genre;
    private Long schoolId;

    public Student() {
    }

    public Student(String id, String name, String genre, Long schoolId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.schoolId = schoolId;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", schoolId=" + schoolId +
                '}';
    }
}
