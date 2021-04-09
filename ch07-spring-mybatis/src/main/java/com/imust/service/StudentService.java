package com.imust.service;

import com.imust.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> queryStudents();
}
