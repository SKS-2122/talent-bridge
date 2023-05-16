package com.talentbridge.talentbridge.repository;

import com.talentbridge.talentbridge.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
