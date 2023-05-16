package com.talentbridge.talentbridge.service.implementations;

import com.talentbridge.talentbridge.models.Student;
import com.talentbridge.talentbridge.repository.StudentRepository;
import com.talentbridge.talentbridge.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // create a student
    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    // fina all students
    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    // find student by id
    @Override
    public Student findById(Integer studentId) {
        Optional<Student> optional = this.studentRepository.findById(studentId);
        Student studentFromDb = null;
        if(optional.isPresent()){
            studentFromDb = optional.get();
        }
        return studentFromDb;
    }

    // update student
    @Override
    public Student update(Student student, Integer studentId) {
        Optional<Student> optional = this.studentRepository.findById(studentId);
        Student studentFromDb = null;
        if(optional.isPresent()){
            studentFromDb = optional.get();
        }
//        assert studentFromDb != null;
        if(studentFromDb!=null) {
           // studentFromDb.setId(student.getId());
            studentFromDb.setFirstName(student.getFirstName());
            studentFromDb.setLastName(student.getLastName());
            studentFromDb.setEmail(student.getEmail());
            studentFromDb.setPhoneNumber(student.getPhoneNumber());
            studentFromDb.setCity(student.getCity());
            studentFromDb.setEducation(student.getEducation());
            studentFromDb.setGitHub(student.getGitHub());
            studentFromDb.setLinkedin(student.getLinkedin());
            studentFromDb.setAboutYou(student.getAboutYou());
        }


        return this.studentRepository.save(studentFromDb);
    }

    // delete student by  id
    @Override
    public void delete(Integer studentId) {
        Optional<Student> optional = this.studentRepository.findById(studentId);
        Student studentFromDb = null;
        if(optional.isPresent()){
            studentFromDb = optional.get();
        }
        assert studentFromDb != null;
        this.studentRepository.delete(studentFromDb);
    }
}
