package com.talentbridge.talentbridge.service.implementations;

import com.talentbridge.talentbridge.models.Company;
import com.talentbridge.talentbridge.models.Vacancy;
import com.talentbridge.talentbridge.repository.CompanyRepository;
import com.talentbridge.talentbridge.repository.VacancyRepository;
import com.talentbridge.talentbridge.service.interfaces.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Vacancy save(Vacancy vacancy,Integer companyId)
    {
        Optional<Company> optional = this.companyRepository.findById(companyId);
        Company company = null;
        if(optional.isPresent()){
            company = optional.get();
        }
        vacancy.setCompany(company);
        return this.vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy findById(Integer vacancyId) {
        Optional<Vacancy> optional = this.vacancyRepository.findById(vacancyId);
        Vacancy vacancy = null;
        if(optional.isPresent()){
            vacancy = optional.get();
        }
        return vacancy;
    }

    @Override
    public List<Vacancy> findAll() {
        List<Vacancy> vacancyList = this.vacancyRepository.findAll();
        return vacancyList;
    }

    @Override
    public Vacancy update(Vacancy vacancy, Integer vacancyId) {
        Optional<Vacancy> optional = this.vacancyRepository.findById(vacancyId);
        Vacancy vacancyFromDb = null;
        if(optional.isPresent()){
            vacancyFromDb = optional.get();
        }
        if(vacancyFromDb != null){
            vacancyFromDb.setJobTitle(vacancy.getJobTitle());
            vacancyFromDb.setJobDescription(vacancy.getJobDescription());
            vacancyFromDb.setSalary(vacancy.getSalary());
        }
        return  this.vacancyRepository.save(vacancyFromDb);
    }

    @Override
    public String delete(Integer vacancyId) {
        Optional<Vacancy> optional = this.vacancyRepository.findById(vacancyId);
        Vacancy vacancyFromDb = null;
        if(optional.isPresent()){
            vacancyFromDb = optional.get();
        }
        this.vacancyRepository.delete(vacancyFromDb);
        return "Vacancy deleted id: "+vacancyId;
    }
}
