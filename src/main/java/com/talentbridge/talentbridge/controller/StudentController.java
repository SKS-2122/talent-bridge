package com.talentbridge.talentbridge.controller;

import com.talentbridge.talentbridge.models.Student;
import com.talentbridge.talentbridge.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // create a student
    @PostMapping("/students")
    public ResponseEntity<Student> save(@RequestBody Student student){
        Student studentFromDb = this.studentService.save(student);
        return new ResponseEntity<Student>(studentFromDb, HttpStatus.CREATED);
    }

    // get all student
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = this.studentService.findAll();
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    // get student by id
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> findById(@PathVariable Integer studentId){
        Student student = this.studentService.findById(studentId);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }

    // update a student
    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> update(@RequestBody Student student,
                                          @PathVariable Integer studentId){
        Student studentFromDb = this.studentService.update(student,studentId);
        return new ResponseEntity<Student>(studentFromDb,HttpStatus.CREATED);
    }
     // Deleting student by id
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> delete(@PathVariable Integer studentId){
        this.studentService.delete(studentId);
        return new ResponseEntity<String>("Student is deleted id "+studentId,HttpStatus.OK);
    }




}
