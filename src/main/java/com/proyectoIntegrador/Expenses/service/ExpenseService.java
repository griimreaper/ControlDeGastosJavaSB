package com.proyectoIntegrador.Expenses.service;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    public List<ExpenseDto> getExpenses();
    public ExpenseDto getExpenseById(String id);
    public void postExpense(ExpenseDto expenseDto) throws InvalidDateException;
    public void deleteExpense(String id);
    public void updateExpense(String id, ExpenseDto expenseDto);
}
