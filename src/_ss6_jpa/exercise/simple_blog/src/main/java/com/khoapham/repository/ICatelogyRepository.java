package com.khoapham.repository;

import com.khoapham.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatelogyRepository extends JpaRepository<Category,Integer> {
}
