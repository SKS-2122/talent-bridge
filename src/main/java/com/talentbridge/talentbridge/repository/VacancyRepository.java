package com.talentbridge.talentbridge.repository;

import com.talentbridge.talentbridge.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {

}
