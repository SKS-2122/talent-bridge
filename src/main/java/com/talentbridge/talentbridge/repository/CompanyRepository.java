package com.talentbridge.talentbridge.repository;

import com.talentbridge.talentbridge.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
