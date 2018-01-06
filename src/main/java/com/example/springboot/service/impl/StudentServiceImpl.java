package com.example.springboot.service.impl;

import com.example.springboot.dao.StudentRepository;
import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.findOne(id);
    }
}
