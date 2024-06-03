package com.example.SpringBootTutorial_JPA_PostgreSQL.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Month;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
//        return List.of(
//                new Student(
//                        1L,
//                        "Magarate Kingston",
//                        "Margarate.Kingston@gmail.com",
//                        LocalDate.of(1993, Month.JANUARY,15),
//                        31
//
//                )
//        );
    }
    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.
                findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email already in use");
        }
        studentRepository.save(student);
       // System.out.println(student);
    }


    public void deleteStudent(Long studentId) {
       boolean exists = studentRepository.existsById(studentId);
       if (!exists) {
           throw new IllegalArgumentException("Student with id" +studentId+ "does not found");
       }
       studentRepository.deleteById(studentId);
    }
    @Transactional
public void updateStudent(Long studentId, String name, String email) {
    Student student= studentRepository.findById(studentId).
            orElseThrow(() -> new IllegalArgumentException(
                    "Student with id" +studentId+ "does not found"));
    if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(),name)) {
        student.setName(name);
    }
        if (!Objects.equals(student.getEmail(), name))
            if ((email != null) && (email.length() > 0)) {
                Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                if (studentOptional.isPresent()) {
                    throw new IllegalStateException("email already in use");
                }
                student.setEmail(email);
            }
    }
}
