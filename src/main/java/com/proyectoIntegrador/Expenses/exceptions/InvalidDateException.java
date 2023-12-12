package com.proyectoIntegrador.Expenses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDateException extends InvalidExpenseException {
    public InvalidDateException(String message) {super(message);}
}
