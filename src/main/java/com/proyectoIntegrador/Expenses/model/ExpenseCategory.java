package com.proyectoIntegrador.Expenses.model;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class ExpenseCategory {
    private String id = UUID.randomUUID().toString();
    private String name;

    public ExpenseCategory(String rsName) {
        this.name = rsName;
    }

    public ExpenseCategory() {
    }

    public ExpenseCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void getCategories (Map<String, Integer> mapa) {
        System.out.println("Contador por categoria:");
        for (Map.Entry<String,Integer> category: mapa.entrySet()) {
            System.out.println(category.getKey()+ ": " + category.getValue());
        }
    }
}
