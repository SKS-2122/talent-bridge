package com.talentbridge.talentbridge.controller;

import com.talentbridge.talentbridge.models.Company;
import com.talentbridge.talentbridge.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // create a company
    @PostMapping("/company")
    public ResponseEntity<Company> save(@RequestBody Company company){
        Company companyFromDb = this.companyService.save(company);
        return new ResponseEntity<Company>(companyFromDb, HttpStatus.CREATED);
    }

    // get company by id
    @GetMapping("/company/{companyId}")
    public ResponseEntity<Company> findById(@PathVariable Integer companyId){
        Company company = this.companyService.findById(companyId);
        return new ResponseEntity<Company>(company,HttpStatus.OK);
    }

    // get all company
    @GetMapping("/company")
    public ResponseEntity<List<Company>> findAll()
    {
        List<Company> companyList = this.companyService.findAll();
        return new ResponseEntity<List<Company>>(companyList,HttpStatus.OK);
    }

    // update Company
    @PutMapping("/company/{companyId}")
    public ResponseEntity<Company> update(@RequestBody Company company,
                                          @PathVariable Integer companyId){
        Company companyFromDb = this.companyService.update(company,companyId);
        return new ResponseEntity<Company>(companyFromDb,HttpStatus.OK);
    }

    // Delete Company
    @DeleteMapping("/company/{companyId}")
    public ResponseEntity<String > delete(@PathVariable Integer companyId){
       String message = this.companyService.delete(companyId);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}
