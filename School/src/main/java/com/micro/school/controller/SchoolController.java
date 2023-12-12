package com.micro.school.controller;

import com.micro.school.dto.SchoolDto;
import com.micro.school.entity.School;
import com.micro.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;


    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School saveSchool(@RequestBody School entity) {
        return schoolService.saveSchool(entity);
    }

    @GetMapping("/with_students/{school_id}")
    public ResponseEntity<SchoolDto> findSchoolsWithStudents(@PathVariable("school_id") Long schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        schoolService.deleteById(id);
    }
}
