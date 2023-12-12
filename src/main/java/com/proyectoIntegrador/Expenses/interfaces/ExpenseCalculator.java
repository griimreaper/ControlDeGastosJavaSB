package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.model.Expense;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;

import java.util.List;

public interface ExpenseCalculator {
    double calculateExpense(Expense expense);
    double calculateTotalExpense(List<Expense> expenses);

    double calculateAmount (List<Double> amounts);

    double calculateTotalExpenseDto(List<ExpenseDto> allExpenses);
}
