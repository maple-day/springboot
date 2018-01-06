package com.example.springboot.dao;

import com.example.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    
    @Query("select s from Student s left join s.teachers t   where s.id=:id")
    Student findStudentAndTeacherById(@Param("id") Integer id);
}
