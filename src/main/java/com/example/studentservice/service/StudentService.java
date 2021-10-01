package com.example.studentservice.service;

import com.example.studentservice.VO.Department;
import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseTemplateVO getUserWithDepartment(Long studentId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findById(studentId).get();
        vo.setStudent(student);
        Department department =
                restTemplate.getForObject("http://localhost:9001/department/"
                                + student.getDepartmentId(),
                        Department.class);

        vo.setDepartment(department);

        return vo;
    }
}
