package com.example.demo.service;

import com.example.demo.Model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> GetAllStudent();

    public Student SaveStudent(Student student);

    public Student GetStudent(String studentid);

    public void GetDeleteStudent(String studentid);

    public Student UpdateStudent(Student student);
}

