package com.micro.school.dto;

import com.micro.school.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolDto {

    private String name;
    private String email;

    List<Student> students;
}
