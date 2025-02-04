package com.example.school_service.service;

import com.example.school_service.entity.School;

import java.util.List;

public interface ISchoolService {
    School save(School school);
    List<School> findAll();
    School findById(Long id);
    School update(Long id, School school);
    void deleteById(Long id);
}