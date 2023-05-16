package com.talentbridge.talentbridge.service.implementations;

import com.talentbridge.talentbridge.models.Skills;
import com.talentbridge.talentbridge.models.Student;
import com.talentbridge.talentbridge.repository.SkillsRepository;
import com.talentbridge.talentbridge.repository.StudentRepository;
import com.talentbridge.talentbridge.service.interfaces.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsServiceImpl implements SkillsService {
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Skills save(Skills skills, Integer studentId) {
        Optional<Student> optional = this.studentRepository.findById(studentId);
        Student studentFromDb = null;
        if(optional.isPresent()){
            studentFromDb = optional.get();
        }
        skills.setStudent(studentFromDb);

        Skills skillsFromDb = this.skillsRepository.save(skills);


        return skillsFromDb;
    }
    // find all Skills
    @Override
    public List<Skills> findAll() {
        return  this.skillsRepository.findAll();
    }

    // get skills by id
    @Override
    public Skills findById(Integer skillId) {
        Optional<Skills> optional = this.skillsRepository.findById(skillId);
        Skills skills = null;
        if(optional.isPresent()){
            skills = optional.get();
        }
        return skills;
    }

    @Override
    public Skills update(Skills skills, Integer skillId) {
       Optional<Skills> optional = this.skillsRepository.findById(skillId);
       Skills skillsFromDb = null;
       if(optional.isPresent()){
           skillsFromDb = optional.get();
       }
       if(skillsFromDb != null){
           skillsFromDb.setTitle(skills.getTitle());
           skillsFromDb.setDescription(skills.getDescription());
       }
        assert skillsFromDb != null;
        return this.skillsRepository.save(skillsFromDb);
    }

    @Override
    public void delete(Integer skillId) {
        Optional<Skills> optional = this.skillsRepository.findById(skillId);
        Skills skillsFromDb = null;
        if(optional.isPresent()){
            skillsFromDb = optional.get();
        }
        assert skillsFromDb != null;
        this.skillsRepository.delete(skillsFromDb);
    }


}
