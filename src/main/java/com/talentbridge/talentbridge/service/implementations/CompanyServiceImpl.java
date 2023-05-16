package com.talentbridge.talentbridge.service.implementations;

import com.talentbridge.talentbridge.models.Company;
import com.talentbridge.talentbridge.repository.CompanyRepository;
import com.talentbridge.talentbridge.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Company save(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public Company findById(Integer companyId) {
        Optional<Company> optional = this.companyRepository.findById(companyId);
        Company company = null;
        if(optional.isPresent()){
            company = optional.get();
        }
        return company;
    }

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company update(Company company, Integer companyId) {
        Optional<Company> optional = this.companyRepository.findById(companyId);
        Company companyFromDb = null;
        if(optional.isPresent()){
            companyFromDb = optional.get();
        }
        if(companyFromDb != null){
            companyFromDb.setName(company.getName());
            companyFromDb.setLocation(company.getLocation());
            companyFromDb.setSector(company.getSector());
            companyFromDb.setEmail(company.getEmail());
            companyFromDb.setPin(company.getPin());
        }
        assert companyFromDb != null;
        this.companyRepository.save(companyFromDb);
        return companyFromDb;
    }

    @Override
    public String delete(Integer companyId) {
        Optional<Company> optional = this.companyRepository.findById(companyId);
        Company company = null;
        if(optional.isPresent()){
            company = optional.get();
        }
        assert company != null;
        this.companyRepository.delete(company);
        return "Company delete id: "+companyId;
    }
}
