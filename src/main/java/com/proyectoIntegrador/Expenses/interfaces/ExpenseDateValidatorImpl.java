package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;

public class ExpenseDateValidatorImpl implements ExpenseDateValidator {
    @Override
    public boolean notValidDate(String date) throws InvalidDateException {
        String[] parts = date.split("/");

        if (parts.length != 3) {
            throw new InvalidDateException("El formato de la fecha debe ser dd/mm/yyyy");
        }

        int day, month, year;
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidDateException("La fecha debe contener solo números en el formato dd/mm/yyyy");
        }

        if (year < 0) {
            throw new InvalidDateException("El año no puede ser un número negativo");
        }

        if (month < 1 || month > 12) {
            throw new InvalidDateException("El mes debe estar entre 1 y 12");
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[2] = 29; // Si es un año bisiesto, febrero tiene 29 días
        }

        if (day < 1 || day > daysInMonth[month]) {
            throw new InvalidDateException("El día no es válido para el mes y año proporcionados");
        }

        return false;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
