package com.proyectoIntegrador.Expenses.service.impl;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;
import com.proyectoIntegrador.Expenses.repository.impl.ExpenseCategoryImplh2;
import com.proyectoIntegrador.Expenses.repository.impl.ExpenseImplH2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("Test de servicio Gastos")
class ExpenseServiceImplTest {
    @Mock
    ExpenseDto expenseDtoMock;
    @Mock
    ExpenseImplH2 expenseImplH2Mock;
    @Mock
    ExpenseCategoryImplh2 expenseCategoryImplh2Mock;
    @InjectMocks
    ExpenseServiceImpl expenseServiceMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        expenseDtoMock = new ExpenseDto("idFalso", 20000.0,"comida","20/12/1999");
    }

    @Test
    @DisplayName("Obtener Todos los gastos")
    void getExpenses() {
        expenseServiceMock.getExpenses();
        verify(expenseImplH2Mock).getAllExpenses();
    }

    @Test
    @DisplayName("Insertar un gasto")
    void postExpense() throws InvalidDateException {
        expenseServiceMock.postExpense(expenseDtoMock);
        verify(expenseCategoryImplh2Mock).getCategoryByName("Comida");
        verify(expenseImplH2Mock).insert(expenseDtoMock);
    }

    @Test
    @DisplayName("Obtener un gasto por id")
    void getExpenseById() {
        String id = "idFalso";
        expenseServiceMock.getExpenseById(id);
        verify(expenseImplH2Mock).getExpense(id);
    }

    @Test
    @DisplayName("Eliminar un gasto")
    void deleteExpense() {
        String id = "idFalso";
        expenseServiceMock.deleteExpense(id);
        verify(expenseImplH2Mock).delete(id);
    }

    @Test
    @DisplayName("Actualizar un gasto")
    void updateExpense() {
        String id = "idFalso";
        expenseServiceMock.updateExpense(id, expenseDtoMock);
        verify(expenseImplH2Mock).update(id, expenseDtoMock);
    }
}