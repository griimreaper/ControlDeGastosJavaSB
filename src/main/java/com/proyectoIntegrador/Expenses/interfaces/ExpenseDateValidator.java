package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;

@FunctionalInterface
public interface ExpenseDateValidator {
    boolean notValidDate(String date) throws InvalidDateException;
}
