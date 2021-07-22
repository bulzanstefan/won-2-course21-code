package com.fasttrackit.curs21.repository;

import com.fasttrackit.curs21.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
