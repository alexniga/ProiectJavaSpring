package com.example.proiectjavacoolapp.repository;

import com.example.proiectjavacoolapp.model.CoolCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoolCompanyRepository extends JpaRepository<CoolCompany, Integer> {
}
