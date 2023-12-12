package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.exceptions.InvalidExpenseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test de validador de montos")
class ExpenseAmountValidatorImplTest {
    @InjectMocks
    ExpenseAmountValidatorImpl expenseAmountValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Numero negativo")
    void notValidAmount() {
        InvalidExpenseException exception = assertThrowsExactly(InvalidExpenseException.class, ()-> expenseAmountValidator.notvalidAmount(-200.0));
        assertEquals(exception.getMessage(), "El monto debe ser igual o mayor a cero");
    }

    @Test
    @DisplayName("Valor correcto")
    void correctValue() throws InvalidExpenseException {
        assertEquals(expenseAmountValidator.notvalidAmount(2000.0), false);
    }
}