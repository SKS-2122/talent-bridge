package com.talentbridge.talentbridge.controller;

import com.talentbridge.talentbridge.models.Skills;
import com.talentbridge.talentbridge.service.interfaces.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    // create a skills
    @PostMapping("/students/{studentId}/skills")
    public ResponseEntity<Skills> save(@RequestBody Skills skills,
                                       @PathVariable Integer studentId){
        Skills skillsFromDb = this.skillsService.save(skills,studentId);
        return new ResponseEntity<Skills>(skillsFromDb, HttpStatus.CREATED);
    }

    // get all skills
    @GetMapping("/skills")
    public ResponseEntity<List<Skills>> findAll(){
        List<Skills> skills = this.skillsService.findAll();
        return new ResponseEntity<List<Skills>>(skills,HttpStatus.OK);
    }

    // get Skills by id
    @GetMapping("/skills/{skillId}")
    public ResponseEntity<Skills> findById(@PathVariable Integer skillId){
        Skills skills = this.skillsService.findById(skillId);
        return new ResponseEntity<Skills>(skills,HttpStatus.OK);
    }

    // update skills
    @PutMapping("/skills/{skillId}")
    public ResponseEntity<Skills> update(@RequestBody Skills skills,
                                         @PathVariable Integer skillId){
        Skills skillsFromDb = this.skillsService.update(skills,skillId);

        return new ResponseEntity<Skills>(skillsFromDb,HttpStatus.CREATED);
    }

    // delete Skills by id
    @DeleteMapping("/skills/{skillId}")
    public ResponseEntity<String> delete(@PathVariable Integer skillId){
        this.skillsService.delete(skillId);
        return new ResponseEntity<String>("Skill is deleted id "+skillId,HttpStatus.OK);
    }
}
