package com.proyectoIntegrador.Expenses.controller;

import com.proyectoIntegrador.Expenses.exceptions.InvalidDateException;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;
import com.proyectoIntegrador.Expenses.service.impl.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseServiceImpl expenseService;

    @GetMapping
    public List<ExpenseDto> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/{id}")
    public ExpenseDto getExpenseById(@PathVariable String id) {return  expenseService.getExpenseById(id);}

    @PostMapping
    public void insertExpense(@RequestBody ExpenseDto expenseDto) throws InvalidDateException { expenseService.postExpense(expenseDto);}

    @PutMapping("/{id}")
    public void updateExpense(@PathVariable String id, @RequestBody ExpenseDto expenseDto) { expenseService.updateExpense(id, expenseDto);}

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) { expenseService.deleteExpense(id);}
}
