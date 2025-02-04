package com.exemple.student_service.service.impl;

import com.exemple.student_service.client.SchoolClient;
import com.exemple.student_service.dto.SchoolDTO;
import com.exemple.student_service.dto.StudentWithSchool;
import com.exemple.student_service.entity.Student;
import com.exemple.student_service.repository.StudentRepository;
import com.exemple.student_service.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;
    private final SchoolClient schoolClient;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolClient schoolClient) {
        this.studentRepository = studentRepository;
        this.schoolClient = schoolClient;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(String id, Student studentDetails) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentDetails.getName());
                    student.setGenre(studentDetails.getGenre());
                    student.setSchoolId(studentDetails.getSchoolId());
                    return studentRepository.save(student);
                }).orElse(null);
    }

    @Override
    public StudentWithSchool findByIdWithSchool(String id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return null;


        SchoolDTO school = schoolClient.getSchoolById(student.getSchoolId());

        return new StudentWithSchool(student, school);
    }


    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}