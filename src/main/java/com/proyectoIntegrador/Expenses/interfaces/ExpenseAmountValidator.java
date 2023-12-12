package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.exceptions.InvalidExpenseException;

@FunctionalInterface
public interface ExpenseAmountValidator {
    boolean notvalidAmount(double amount) throws InvalidExpenseException;
}
