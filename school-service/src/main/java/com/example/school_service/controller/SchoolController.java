package com.example.school_service.controller;

import com.example.school_service.entity.School;
import com.example.school_service.service.ISchoolService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final ISchoolService schoolService;


    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<School> create(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.save(school));
    }

    @GetMapping
    public ResponseEntity<List<School>> getAll() {
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> update(@PathVariable Long id, @RequestBody School schoolDetails) {
        School updatedSchool = schoolService.update(id, schoolDetails);
        if (updatedSchool == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSchool);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        schoolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}