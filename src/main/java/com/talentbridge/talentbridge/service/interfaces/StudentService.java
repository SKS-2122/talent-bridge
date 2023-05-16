package com.talentbridge.talentbridge.service.interfaces;

import com.talentbridge.talentbridge.models.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student); // save a student
    List<Student> findAll(); // get all student
    Student findById(Integer studentId); // get student by id
    Student update(Student student,Integer studentId); // update a student
    void delete(Integer studentId); // delete student by id;
}
