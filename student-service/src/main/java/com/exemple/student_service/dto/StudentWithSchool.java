package com.exemple.student_service.dto;

import com.exemple.student_service.entity.Student;

public class StudentWithSchool {
    private Student student;
    private SchoolDTO school;

    public StudentWithSchool() {
    }

    public StudentWithSchool(Student student, SchoolDTO school) {
        this.student = student;
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "StudentWithSchool{" +
                "student=" + student +
                ", school=" + school +
                '}';
    }
}