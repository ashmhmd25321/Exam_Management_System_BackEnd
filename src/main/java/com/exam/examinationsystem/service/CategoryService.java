package com.exam.examinationsystem.service;

import com.exam.examinationsystem.models.exam.Category;

import java.util.Set;

public interface CategoryService {

    //create
    public Category addCategory(Category category);

    //update
    public Category updateCategory(Category category);

    //get all
    public Set<Category> getCategories();

    //get by ID
    public Category getCategory(Long categoryId);

    //delete by ID
    public void deleteCategory(Long categoryId);
}
