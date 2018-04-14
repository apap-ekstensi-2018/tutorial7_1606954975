package com.example.dao;

import com.example.model.StudentModel;
import com.sun.tools.javac.code.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public StudentModel selectStudent(String npm) {
        StudentModel student = restTemplate.getForObject("http://localhost:8181/rest/student/view/"+npm, StudentModel.class);
        return student;
    }

    @Override
    public List<StudentModel> selectAllStudents() {
        StudentModel[] student = restTemplate.getForObject("http://localhost:8181/rest/student/viewall", StudentModel[].class);
        return Arrays.asList(student);
    }
}
