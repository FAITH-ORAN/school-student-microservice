package com.exemple.student_service.client;

import com.exemple.student_service.dto.SchoolDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "school-service", url = "http://localhost:8080")
public interface SchoolClient {
    @GetMapping("/schools/{id}")
    SchoolDTO getSchoolById(@PathVariable Long id);
}

