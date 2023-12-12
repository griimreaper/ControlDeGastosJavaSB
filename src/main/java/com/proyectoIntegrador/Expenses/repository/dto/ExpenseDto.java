package com.proyectoIntegrador.Expenses.repository.dto;

import java.util.UUID;

public class ExpenseDto {
    private String id = UUID.randomUUID().toString();
    private Double amount;
    private String categoryId;
    private String date;


    public ExpenseDto(Double amount, String categoryId, String date) {
        this.amount = amount;
        this.categoryId = categoryId;
        this.date = date;
    }

    public ExpenseDto(Double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public ExpenseDto(String id, Double amount, String category, String date) {
        this.id = id;
        this.amount = amount;
        this.categoryId = category;
        this.date = date;
    }

    public ExpenseDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return categoryId;
    }

    public void setCategory(String category) {
        this.categoryId = category;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Id = " + id + "\n" +
                "Amount = " + amount + "\n" +
                "Category = " + categoryId + '\n' +
                "Date = " + date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
