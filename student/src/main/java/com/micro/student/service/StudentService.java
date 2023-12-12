package com.micro.student.service;

import com.micro.student.entity.Student;
import com.micro.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student saveStudent(Student entity) {
        return studentRepo.save(entity);
    }

    public Student findById(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> findAllStudentsBySchool(Long schoolId) {
        return studentRepo.findAllBySchoolId(schoolId);
    }
}
