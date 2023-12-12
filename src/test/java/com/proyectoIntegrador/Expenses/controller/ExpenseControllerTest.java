package com.proyectoIntegrador.Expenses.controller;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;
import com.proyectoIntegrador.Expenses.service.impl.ExpenseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Test De Controladores De Gastos.")
class ExpenseControllerTest {
    @Mock
    ExpenseDto expenseDtoMock;
    @Mock
    ExpenseServiceImpl expenseServiceImplMock;
    @InjectMocks
    ExpenseController expenseControllerMock;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Obtener todos los gastos.")
    void getExpensesTest() {
        List<ExpenseDto> result = expenseControllerMock.getExpenses();
        when(expenseServiceImplMock.getExpenses()).thenReturn(result);
        verify(expenseServiceImplMock).getExpenses();
    }

    @Test
    @DisplayName("Obtener un gasto por id")
    void getExpenseById() {
        String id = "idFalso";

        ExpenseDto result = expenseControllerMock.getExpenseById(id);

        when(expenseControllerMock.getExpenseById(id)).thenReturn(result);
        verify(expenseServiceImplMock).getExpenseById(id);
    }

    @Test
    @DisplayName("Insertar un gasto.")
    void insertExpense() throws InvalidDateException {
        expenseControllerMock.insertExpense(expenseDtoMock);

        verify(expenseServiceImplMock).postExpense(expenseDtoMock);
    }

    @Test
    @DisplayName("Actualizar un gasto.")
    void updateExpense() {
        String id = "idFalso";

        expenseControllerMock.updateExpense(id, expenseDtoMock);

        verify(expenseServiceImplMock).updateExpense(id, expenseDtoMock);
    }

    @Test
    @DisplayName("Eliminar un gasto.")
    void deleteExpense() {
        String id = "idFalso";

        expenseControllerMock.deleteExpense(id);

        verify(expenseServiceImplMock).deleteExpense(id);
    }
}