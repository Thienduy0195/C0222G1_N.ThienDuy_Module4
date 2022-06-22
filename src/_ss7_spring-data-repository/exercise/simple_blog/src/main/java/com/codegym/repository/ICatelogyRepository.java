package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatelogyRepository extends JpaRepository<Category,Integer> {
}
