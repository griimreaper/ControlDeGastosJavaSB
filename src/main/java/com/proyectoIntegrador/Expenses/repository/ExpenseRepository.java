package com.proyectoIntegrador.Expenses.repository;

import com.proyectoIntegrador.Expenses.model.Expense;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;

import java.util.List;

public interface ExpenseRepository {
    public void insert(ExpenseDto expense);
    public void update(String id, ExpenseDto expense);
    public void delete(String id);
    public void readExpense(String id);
    public ExpenseDto getExpense(String id);
    public List<ExpenseDto> getAllExpenses();
}
