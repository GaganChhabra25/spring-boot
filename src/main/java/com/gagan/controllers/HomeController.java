package com.gagan.controllers;


import com.gagan.entities.Student;
import com.gagan.service.StudentService;
import org.hibernate.validator.internal.xml.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("home")
    public String home(){
        return "Welcome to Spring boot application";
    }

    @RequestMapping("student")
    public Student  getStudent() {
        return new Student("gagan");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public void create(@RequestBody Student student){
        System.out.println("into controller");
        System.out.println(student.getName());
        studentService.create(student);
    }
}
