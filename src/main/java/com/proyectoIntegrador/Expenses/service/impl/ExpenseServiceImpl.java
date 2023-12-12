package com.proyectoIntegrador.Expenses.service.impl;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;
import com.proyectoIntegrador.Expenses.interfaces.ExpenseDateValidator;
import com.proyectoIntegrador.Expenses.interfaces.ExpenseDateValidatorImpl;
import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;
import com.proyectoIntegrador.Expenses.repository.impl.ExpenseCategoryImplh2;
import com.proyectoIntegrador.Expenses.repository.impl.ExpenseImplH2;
import com.proyectoIntegrador.Expenses.service.ExpenseService;
import com.proyectoIntegrador.Expenses.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseImplH2 expenseImplH2;
    private final ExpenseCategoryImplh2 expenseCategoryImplh2;

    @Autowired
    public ExpenseServiceImpl(ExpenseImplH2 expenseRespository, ExpenseCategoryImplh2 expenseCategoryImplh2) {
        this.expenseImplH2 = expenseRespository;
        this.expenseCategoryImplh2 = expenseCategoryImplh2;
    }

    @Override
    public List<ExpenseDto> getExpenses() {
        return expenseImplH2.getAllExpenses();
    }

    @Override
    public ExpenseDto getExpenseById(String id) {
        return expenseImplH2.getExpense(id);
    }

    @Override
    public void postExpense(ExpenseDto expenseDto) throws InvalidDateException {
        String categoryName = expenseDto.getCategory();
        String capitalizeName = Utilities.capitalize(categoryName);

        ExpenseDateValidator expenseDateValidator = new ExpenseDateValidatorImpl();
        expenseDateValidator.notValidDate(expenseDto.getDate());

        Optional<ExpenseCategory> expenseCategory = expenseCategoryImplh2.getCategoryByName(capitalizeName);

        ExpenseCategory newExpenseCategory;
        if (expenseCategory.isEmpty()) {
            newExpenseCategory = new ExpenseCategory(capitalizeName);
            expenseCategoryImplh2.insert(newExpenseCategory);
        } else {
            newExpenseCategory = expenseCategory.get();
            System.out.println(newExpenseCategory);
        }

        expenseDto.setCategory(newExpenseCategory.getId());
        expenseImplH2.insert(expenseDto);
    }

    @Override
    public void deleteExpense(String id) {
        expenseImplH2.delete(id);
    }

    @Override
    public void updateExpense(String id, ExpenseDto expenseDto) {
        expenseImplH2.update(id, expenseDto);
    }
}
