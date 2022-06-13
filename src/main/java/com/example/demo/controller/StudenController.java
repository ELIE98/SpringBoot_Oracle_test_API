package com.example.demo.controller;

import com.example.demo.Model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudenController {

    @Autowired
    private IStudentService StudentSce;

    @GetMapping("/students")
    public List<Student> GetStudentAll() {
        return StudentSce.GetAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student GetStudent(@PathVariable("id") String id) {
        return StudentSce.GetStudent(id);
    }

    @PostMapping("/student")
    public Student CreateStudent(@RequestBody Student student) {
        return StudentSce.SaveStudent(student);
    }

    @PostMapping("/updatestudent")
    public Student UpdateStudent(@RequestBody Student student) {
        return StudentSce.UpdateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String GetDeleteStudent(@PathVariable("id") String id) {
        StudentSce.GetDeleteStudent(id);
        return "Student deleted successfully";
    }
}
