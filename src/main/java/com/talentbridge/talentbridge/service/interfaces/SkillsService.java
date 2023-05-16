package com.talentbridge.talentbridge.service.interfaces;

import com.talentbridge.talentbridge.models.Skills;
import com.talentbridge.talentbridge.models.Student;

import java.util.List;

public interface SkillsService {

    Skills save(Skills skills,Integer studentId); // create Skills
    List<Skills> findAll(); // get all student
    Skills findById(Integer skillId); // get student by id
    Skills update(Skills skills,Integer skillId); // update a student
    void delete(Integer skillId); // delete student by id;
}
