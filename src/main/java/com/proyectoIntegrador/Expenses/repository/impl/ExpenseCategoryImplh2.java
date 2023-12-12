package com.proyectoIntegrador.Expenses.repository.impl;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpenseCategoryImplh2 implements ExpenseCategoryRepository {
    private final Connection connection;

    @Autowired
    public ExpenseCategoryImplh2(Connection connection) {
        this.connection = connection;
        try {
            Statement statement = connection.createStatement();
            String createTableExpense = "CREATE TABLE IF NOT EXISTS expensesCategory (id VARCHAR(60) PRIMARY KEY, name VARCHAR(60))";
            statement.executeUpdate(createTableExpense);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void insert(ExpenseCategory expenseCategory) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO expensescategory (id, name) VALUES (?, ?)");
            preparedStatement.setString(1, expenseCategory.getId());
            preparedStatement.setString(2, expenseCategory.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String newName, String id) {
        String sql = "UPDATE expensescategory SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, id);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La categoria se actualizo correctamente.");
            } else {
                System.out.println("No se encontro la categoria correspondiente.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM expensescategory WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La categoria se eliminó exitosamente.");
            } else {
                System.out.println("No se encontró la categoria especificada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExpenseCategory> getAllCategories() {
        List<ExpenseCategory> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM expensescategory");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String rsId = resultSet.getString("id");
                String rsName = resultSet.getString("name");

                ExpenseCategory ctgr = new ExpenseCategory(rsName);
                ctgr.setId(rsId);

                categories.add(ctgr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public ExpenseCategory getCategoryById(String id) {
        ExpenseCategory category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM expensescategory WHERE id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String rsId = resultSet.getString("id");
                String rsName = resultSet.getString("name");

                category = new ExpenseCategory(rsName);
                category.setId(rsId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    public Optional<ExpenseCategory> getCategoryByName(String name) {
        try {
            return getAllCategories()
                    .stream()
                    .filter(expenseCategory1 -> expenseCategory1.getName().equalsIgnoreCase(name))
                    .findFirst();
        } catch (NullPointerException e) {
            return Optional.empty();
        }

    }
}
