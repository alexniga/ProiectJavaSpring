package com.example.proiectjavacoolapp.repository;

import com.example.proiectjavacoolapp.model.CookedFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookedFoodRepository extends JpaRepository<CookedFood, Integer> {
}
