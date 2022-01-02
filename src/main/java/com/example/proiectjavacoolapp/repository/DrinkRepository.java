package com.example.proiectjavacoolapp.repository;

import com.example.proiectjavacoolapp.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
