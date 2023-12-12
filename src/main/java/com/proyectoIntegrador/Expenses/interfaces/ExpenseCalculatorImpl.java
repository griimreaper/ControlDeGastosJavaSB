package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.model.Expense;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;

import java.util.List;

public class ExpenseCalculatorImpl implements ExpenseCalculator {
    @Override
    public double calculateExpense(Expense expense) {
        return expense.getAmount();
    }

    @Override
    public double calculateTotalExpense(List<Expense> expenses) {
        double totalExpense = 0;
        for (Expense expense: expenses) {
            totalExpense += expense.getAmount();
        }
        return totalExpense;
    }

    @Override
    public double calculateAmount(List<Double> amounts) {
        double totalExpense = 0;
        for (Double amount: amounts) {
            totalExpense += amount;
        }
        return totalExpense;
    }

    @Override
    public double calculateTotalExpenseDto(List<ExpenseDto> allExpenses) {
        double totalExpense = 0;
        for (ExpenseDto expense: allExpenses) {
            totalExpense += expense.getAmount();
        }
        return totalExpense;
    }
}
