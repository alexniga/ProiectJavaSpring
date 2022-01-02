package com.example.proiectjavacoolapp.repository;

import com.example.proiectjavacoolapp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDataRepository extends JpaRepository<ContactData, Integer> {
}
