package com.exam.examinationsystem.controller;

import com.exam.examinationsystem.models.exam.Category;
import com.exam.examinationsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category cat1=this.categoryService.addCategory(category);
        return  ResponseEntity.ok(cat1);
    }

    //get single category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId)
    {
        return  this.categoryService.getCategory(categoryId);
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
        return  ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update any category
    @PutMapping("/")
    public  Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);
    }

    //delete Category
    @DeleteMapping("/{categoryId}")
    public  void  DeleteCategory(@PathVariable("categoryId") Long categoryId)
    {
        this.categoryService.deleteCategory(categoryId);
    }
}
