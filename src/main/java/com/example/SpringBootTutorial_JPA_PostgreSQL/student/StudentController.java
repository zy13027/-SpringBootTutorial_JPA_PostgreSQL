package com.example.SpringBootTutorial_JPA_PostgreSQL.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/student")


public class StudentController {
    private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {

    this.studentService = studentService;
    }
    @GetMapping
public List<Student> getStudents() {
        return studentService.getStudents();
}
@PostMapping //PostMapping Request
public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
    }
    @DeleteMapping(path ="{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId) {
    studentService.deleteStudent(studentId);
    }
    @PutMapping(path ="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
    {studentService.updateStudent(studentId,name,email);
    }
}
