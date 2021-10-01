package com.example.studentservice.controller;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class StudentController {
    @Autowired
    private StudentService studentService;

    //Save
    @PostMapping("/")
    public Student saveUser(@RequestBody Student student){

        return studentService.saveStudent(student);
    }


    //Get All User and Department by id
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id")
                                                            Long studentId){
        return studentService.getUserWithDepartment(studentId);
    }
}
