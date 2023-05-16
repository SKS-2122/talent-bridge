package com.talentbridge.talentbridge.service.interfaces;

import com.talentbridge.talentbridge.models.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy save(Vacancy vacancy,Integer companyId); // save vacancy
    Vacancy findById(Integer vacancyId); // find vacancy by id
    List<Vacancy> findAll(); // find all vacancy
    Vacancy update (Vacancy vacancy,Integer vacancyId);  // update vacancy
    String delete(Integer vacancyId); // delete vacancy
}
