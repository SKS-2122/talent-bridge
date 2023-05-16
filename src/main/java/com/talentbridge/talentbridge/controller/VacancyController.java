package com.talentbridge.talentbridge.controller;

import com.talentbridge.talentbridge.models.Vacancy;
import com.talentbridge.talentbridge.service.interfaces.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    // create vacancy
    @PostMapping("/company/{companyId}/vacancy")
    public ResponseEntity<Vacancy> save(@RequestBody Vacancy vacancy,
                                        @PathVariable Integer companyId){
        Vacancy vacancyFromDb = this.vacancyService.save(vacancy,companyId);
        return new ResponseEntity<Vacancy>(vacancyFromDb, HttpStatus.CREATED);
    }
    // get all vacancy
    @GetMapping("/vacancy")
    public ResponseEntity<List<Vacancy>> findAll(){
       List<Vacancy> vacancyList =  this.vacancyService.findAll();
       return new ResponseEntity<List<Vacancy>>(vacancyList,HttpStatus.OK);
    }
    // get vacancy by id
    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity<Vacancy> findById(@PathVariable Integer vacancyId){
     Vacancy vacancy = this.vacancyService.findById(vacancyId);
     return new ResponseEntity<Vacancy>(vacancy,HttpStatus.OK);
    }
    // update vacancy by id
    @PutMapping("/vacancy/{vacancyId}")
    public ResponseEntity<Vacancy> update(@RequestBody Vacancy vacancy,
                                          @PathVariable Integer vacancyId){
        Vacancy vacancyFromDb = this.vacancyService.update(vacancy,vacancyId);
        return new ResponseEntity<Vacancy>(vacancyFromDb,HttpStatus.OK);
    }

    // delete vacancy
    @DeleteMapping("/vacancy/{vacancyId}")
    public ResponseEntity<String> delete(@PathVariable Integer vacancyId){
        String message = this.vacancyService.delete(vacancyId);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }

}
