package com.example.school_service.service.impl;

import com.example.school_service.entity.School;
import com.example.school_service.repository.SchoolRepository;
import com.example.school_service.service.ISchoolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements ISchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    public School update(Long id, School schoolDetails) {
        return schoolRepository.findById(id)
                .map(school -> {
                    school.setName(schoolDetails.getName());
                    school.setAddress(schoolDetails.getAddress());
                    school.setDirectorName(schoolDetails.getDirectorName());
                    return schoolRepository.save(school);
                }).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        schoolRepository.deleteById(id);
    }
}
