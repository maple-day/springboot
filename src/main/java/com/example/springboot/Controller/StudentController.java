package com.example.springboot.Controller;

import com.example.springboot.dao.StudentRepository;
import com.example.springboot.dao.TeacherRepository;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Teacher;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentService studentService;
    
    @RequestMapping("/{id}/{name}")
    @ResponseBody
    public String addDate(@PathVariable Integer id,@PathVariable String name){
        for (int i=0;i<10;i++){
            Student student = new Student();
            student.setId(i);
            student.setName("学生:"+i);
            studentRepository.save(student);
        }
        
        HashSet<Teacher> teachers = new HashSet<>();
        for (int i=0;i<10;i++){
            Teacher teacher = new Teacher();
            teacher.setId(i);
            teacher.setName("老师"+i);
            teachers.add(teacher);
        }
        teacherRepository.save(teachers);
        return  id+name;
    }
    
    @RequestMapping("/helloworld")
    @ResponseBody
    public String sayHello(){
        return "hello world";
    }
    
    @RequestMapping("/relation/{id}")
    @ResponseBody
    public String Relation(@PathVariable("id") Integer id){
        Teacher teacher = teacherRepository.findOne(id);
        Student student = studentRepository.findOne(id);
        Set<Teacher> list =new HashSet<>();
        list.add(teacher);
        student.setTeachers(list);
        Student save = studentRepository.save(student);
        return save.toString();
    }
    
    @RequestMapping("/findTeacherAndStudent/{id}")
    @ResponseBody
    public Student findTeacherAndStudent(@PathVariable("id") Integer id){
        Student student = studentRepository.findStudentAndTeacherById(id);
        return student;
    }
    @RequestMapping("/{id}")
    @ResponseBody
    public Teacher findById(@PathVariable("id") Integer id){
        return teacherRepository.findOne(id);
    }
    
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> findAll(){
        List<Student> list = studentRepository.findAll();
        return list;
    }
    
    @RequestMapping("/findStudent/{id}")
    @ResponseBody
    public Student findStudentById(@PathVariable("id") Integer id){
        Student student = studentService.findStudentById(id);
//        student.getTeachers();
        return student;
    }
    
    @RequestMapping("/student/{id}")
    public String toStudent(@PathVariable("id") Integer id, Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        model.addAttribute("hello","hello springboot");
        return "student";
    }
}
