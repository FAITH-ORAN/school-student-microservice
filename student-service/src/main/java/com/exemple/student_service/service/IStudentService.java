package com.exemple.student_service.service;


import com.exemple.student_service.dto.StudentWithSchool;
import com.exemple.student_service.entity.Student;

import java.util.List;

public interface IStudentService {
    Student save(Student student);
    List<Student> findAll();
    StudentWithSchool findByIdWithSchool(String id);
    Student update(String id, Student student);
    void deleteById(String id);
}