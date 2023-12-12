package com.proyectoIntegrador.Expenses.repository;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryRepository {
    public void insert(ExpenseCategory expenseCategory);
    public void update(String name, String newName);
    public void delete(String id);
    public ExpenseCategory getCategoryById(String id);
    public List<ExpenseCategory> getAllCategories();
}
