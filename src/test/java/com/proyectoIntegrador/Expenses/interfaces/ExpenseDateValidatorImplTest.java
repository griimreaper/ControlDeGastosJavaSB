package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@DisplayName("Test de validador de fechas")
class ExpenseDateValidatorImplTest {
    @InjectMocks
    ExpenseDateValidatorImpl expenseDateValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Mal formato")
    @Test
    void badFormat() {
        InvalidDateException exception = assertThrowsExactly(InvalidDateException.class, () -> {
            expenseDateValidator.notValidDate("11/12-2020");
        });
        assertEquals("El formato de la fecha debe ser dd/mm/yyyy", exception.getMessage());
    }

    @Test
    @DisplayName("Dia incorrecto")
    void incorrectDay() {
        InvalidDateException exception = assertThrowsExactly(InvalidDateException.class, () -> expenseDateValidator.notValidDate("32/03/1999"));
        assertEquals("El día no es válido para el mes y año proporcionados", exception.getMessage());
    }

    @Test
    @DisplayName("Mes incorrecto")
    void incorrectMonth(){
        InvalidDateException exception = assertThrowsExactly(InvalidDateException.class, () -> expenseDateValidator.notValidDate("01/21/1999"));
        assertEquals("El mes debe estar entre 1 y 12", exception.getMessage());
    }

    @Test
    @DisplayName("Año incorrecto")
    void incorrectYear() {
        InvalidDateException exception = assertThrowsExactly(InvalidDateException.class, () -> expenseDateValidator.notValidDate("01/01/-2000"));
        assertEquals("El año no puede ser un número negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Solo numeros")
    void justNumbers() {
        InvalidDateException exception = assertThrowsExactly(InvalidDateException.class, () -> expenseDateValidator.notValidDate("sa/12/1999"));
        assertEquals("La fecha debe contener solo números en el formato dd/mm/yyyy", exception.getMessage());
    }

    @Test
    @DisplayName("Año bisiesto")
    void leapYear() throws InvalidDateException {
        boolean result = expenseDateValidator.notValidDate("29/02/2000");
        assertEquals(result, false);
    }

    @Test
    @DisplayName("Dia comun")
    void comunDay() throws InvalidDateException {
        boolean result = expenseDateValidator.notValidDate("30/03/1999");
        assertEquals(result, false);
    }
}