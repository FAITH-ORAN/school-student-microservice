package com.exemple.student_service.repository;

import com.exemple.student_service.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
