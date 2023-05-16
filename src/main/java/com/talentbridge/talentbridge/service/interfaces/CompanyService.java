package com.talentbridge.talentbridge.service.interfaces;

import com.talentbridge.talentbridge.models.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);
    Company findById(Integer companyId);
    List<Company> findAll();
    Company update(Company company,Integer companyId);
    String delete(Integer companyId);
}
