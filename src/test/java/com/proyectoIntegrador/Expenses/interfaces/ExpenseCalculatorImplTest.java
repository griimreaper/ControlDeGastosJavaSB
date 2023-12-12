package com.proyectoIntegrador.Expenses.interfaces;

import com.proyectoIntegrador.Expenses.model.Expense;
import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test de metodos para calcular expensas")
class ExpenseCalculatorImplTest {
    ExpenseCalculatorImpl expenseCalculator = new ExpenseCalculatorImpl();
    @Test
    void calculateTotalExpense() {
        List<Expense> expenses = List.of(
                new Expense(2000.0, new ExpenseCategory("idFalso"),"20/20/1999"),
                new Expense(1000.0, new ExpenseCategory("idFalso"),"20/20/1999"),
                new Expense(3000.0, new ExpenseCategory("idFalso"),"20/20/1999")
        );

            double result = expenseCalculator.calculateTotalExpense(expenses);
            assertEquals(result, 6000.0);
    }

    @Test
    void calculateAmount() {
        List<Double> amounts = List.of(2000.0,1000.0,3000.0);
        double result = expenseCalculator.calculateAmount(amounts);
        assertEquals(result,6000.0);
    }

    @Test
    void calculateTotalExpenseDto() {
        List<ExpenseDto> expenseDtos = List.of(
                new ExpenseDto(4000.0,"20/12/2000"),
                new ExpenseDto(3000.0,"20/12/2000"),
                new ExpenseDto(2000.0,"20/12/2000"),
                new ExpenseDto(1000.0,"20/12/2000")
        );
        double result = expenseCalculator.calculateTotalExpenseDto(expenseDtos);
        assertEquals(result,10000.0);
    }
}