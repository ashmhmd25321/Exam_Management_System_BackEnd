package com.exam.examinationsystem.repository;

import com.exam.examinationsystem.models.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
