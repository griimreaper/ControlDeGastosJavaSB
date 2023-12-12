package com.proyectoIntegrador.Expenses.service.impl;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.repository.impl.ExpenseCategoryImplh2;
import com.proyectoIntegrador.Expenses.service.ExpenseCategoryService;
import com.proyectoIntegrador.Expenses.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {
    private final ExpenseCategoryImplh2 expenseCategoryImplh2;

    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryImplh2 expenseCategoryImplh2) {
        this.expenseCategoryImplh2 = expenseCategoryImplh2;
    }

    @Override
    public void insert(String name) {
        ExpenseCategory expenseCategory = new ExpenseCategory(Utilities.capitalize(name));
        expenseCategoryImplh2.insert(expenseCategory);
    }

    @Override
    public void update(String name, String id) {
        expenseCategoryImplh2.update(Utilities.capitalize(name), id);
    }

    @Override
    public void delete(String id) {
        expenseCategoryImplh2.delete(id);
    }

    @Override
    public ExpenseCategory getCategoryById(String id) {
        return expenseCategoryImplh2.getCategoryById(id);
    }

    @Override
    public List<ExpenseCategory> getAllCategories() {
        return expenseCategoryImplh2.getAllCategories();
    }

    public Map<String, Integer> countCategories() {
        Map<String, Integer> countCategory = new HashMap();
        expenseCategoryImplh2.getAllCategories().forEach(category -> {
            String name = category.getName();
            if (countCategory.containsKey(name)) {
                int count = countCategory.get(name);
                countCategory.put(name, count + 1);
            } else {
                countCategory.put(name, 1);
            }
        });
        return countCategory;
    }
}
