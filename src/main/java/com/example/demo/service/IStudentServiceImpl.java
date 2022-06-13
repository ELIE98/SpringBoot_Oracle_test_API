package com.example.demo.service;

import com.example.demo.Model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository StudentRepo;

    @Override
    public List<Student> GetAllStudent() {
        return StudentRepo.findAll();
    }

    @Override
    public Student SaveStudent(Student student) {
        return StudentRepo.save(student);
    }

    @Override
    public Student GetStudent(String studentid) {
        return StudentRepo.findById(studentid).get();
    }

    @Override
    public void GetDeleteStudent(String studentid) {
        StudentRepo.deleteById(studentid);
    }

    @Override
    public Student UpdateStudent(Student student) {
        Student StudentInDb = StudentRepo.findById(student.getStudentId()).get();
        if (Objects.nonNull(StudentInDb)
                && !"".equalsIgnoreCase(student.getStudentId())
                && !"".equalsIgnoreCase(student.getStudentName())) {
            StudentInDb.setStudentId(student.getStudentId());
            StudentInDb.setStudentName(student.getStudentName());
            return StudentRepo.save(StudentInDb);
        }else {
            return student;
        }

    }
}
