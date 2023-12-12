package com.micro.school.client;

import com.micro.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{school_id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school_id") Long schoolId);

}
