package com.micro.school.service;

import com.micro.school.client.StudentClient;
import com.micro.school.dto.SchoolDto;
import com.micro.school.entity.School;
import com.micro.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepo;
    private final StudentClient client;

    public List<School> findAllSchools() {
        return schoolRepo.findAll();
    }

    public School saveSchool(School entity) {
        return schoolRepo.save(entity);
    }

    public SchoolDto findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepo.findById(schoolId)
                .orElse(
                        School.builder()
                            .name("NOT_FOUND")
                            .email("NOT_FOUND")
                            .build()
                );

        var students = client.findAllStudentsBySchool(schoolId);
        return SchoolDto.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

    public void deleteById(Long id) {
        schoolRepo.deleteById(id);
    }
}
