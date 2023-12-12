package com.proyectoIntegrador.Expenses.controller;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.service.ExpenseCategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class ExpenseCategoryController {
    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    @GetMapping
    public List<ExpenseCategory> getCategories() {
        return expenseCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ExpenseCategory getCategoryById(@PathVariable String id) {
        return expenseCategoryService.getCategoryById(id);
    }

    @PostMapping
    public void insertCategory(@RequestBody @NotNull ExpenseCategory expenseCategory) {
        expenseCategoryService.insert(expenseCategory.getName());
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody @NotNull ExpenseCategory expenseCategory, @PathVariable String id) {
        expenseCategoryService.update(expenseCategory.getName(), id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        expenseCategoryService.delete(id);
    }

    @GetMapping("/count")
    public Map<String, Integer> countCategories() {
        return expenseCategoryService.countCategories();
    }
}
