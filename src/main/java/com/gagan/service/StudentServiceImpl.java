package com.gagan.service;

import com.gagan.entities.Student;
import com.gagan.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void create(Student student) {
        System.out.println("into service");
        studentRepository.save(student);
    }
}
