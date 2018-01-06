package com.example.springboot.service;

import com.example.springboot.entity.Student;

public interface StudentService {
    Student findStudentById(Integer id);
}
