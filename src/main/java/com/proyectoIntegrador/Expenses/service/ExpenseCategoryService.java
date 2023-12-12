package com.proyectoIntegrador.Expenses.service;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ExpenseCategoryService {
    public void insert(String name);
    public void update(String name, String id);
    public void delete(String id);
    public ExpenseCategory getCategoryById(String id);
    public List<ExpenseCategory> getAllCategories();

    Map<String, Integer> countCategories();
}
