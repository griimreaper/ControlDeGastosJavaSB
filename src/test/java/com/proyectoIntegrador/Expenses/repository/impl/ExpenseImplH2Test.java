package com.proyectoIntegrador.Expenses.repository.impl;


import com.proyectoIntegrador.Expenses.config.DatabaseConfigTest;
import com.proyectoIntegrador.Expenses.model.Expense;
import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.repository.dto.ExpenseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@DisplayName("Expense BD Interaction Test")
class ExpenseImplH2Test {
    private final DatabaseConfigTest databaseConfigTest = new DatabaseConfigTest();
    @Mock
    private PreparedStatement preparedStatementMock;
    @Mock
    private Connection connectionMock;
    @Mock
    private ResultSet resultSetMock;
    @Mock
    private ExpenseCategoryImplh2 expenseCategoryImplh2;
    @InjectMocks
    private ExpenseImplH2 expenseImplH2Mock = mock(ExpenseImplH2.class);

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        connectionMock = databaseConfigTest.getDBConnection();
        expenseImplH2Mock = new ExpenseImplH2(connectionMock);
        expenseCategoryImplh2 = new ExpenseCategoryImplh2(connectionMock);
    }

    @AfterEach
        // se eliminan las tablas luego de cada test, asi no se apilan los datos.
    void dropTables() throws SQLException {
        connectionMock.createStatement().executeUpdate("DROP TABLE expenses");
        connectionMock.createStatement().executeUpdate("DROP TABLE expensescategory");
    }

    @Test
    @DisplayName("Agregar un nuevo gasto")
    public void addExpenseTest() throws SQLException {
        Double amount = 20000.0;
        ExpenseCategory category = new ExpenseCategory("comida");
        String date = "20/19/1999";

        Expense expense = new Expense(amount, category, date);

        String sql = "INSERT INTO expenses (id, amount, categoryID, date) VALUES (?, ?, ?, ?)";

        try (Connection connection = databaseConfigTest.getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, expense.getId());
            preparedStatement.setDouble(2, amount);
            preparedStatement.setString(3, category.getId());
            preparedStatement.setString(4, date);

            int rowsAffected = preparedStatement.executeUpdate();

            assertEquals(1, rowsAffected, "Se esperaba que una fila fuera afectada por la inserción");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Excepción al intentar insertar en la base de datos: " + e.getMessage());
        }

    }
    @Test
    @DisplayName("Obtener gasto de BD")
    public void getExpenseTest() throws SQLException {
        ExpenseDto expense = new ExpenseDto(20000.0, "idCategoryFalse", "20/19/1999");
        String sql = "SELECT * FROM expenses WHERE id = ?";

        expenseImplH2Mock.insert(expense);

        ExpenseDto result = expenseImplH2Mock.getExpense(expense.getId());

        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.getString("id")).thenReturn(anyString());
        when(resultSetMock.getDouble("amount")).thenReturn(20000.0);
        when(resultSetMock.getString("date")).thenReturn("20/19/1999");
        when(resultSetMock.getString("category")).thenReturn("idCategoryFalse");

        assertEquals(result.getId(),expense.getId());
        assertEquals(result.getCategory(), expense.getCategory());
        assertEquals(result.getAmount(), expense.getAmount());
        assertEquals(result.getDate(), expense.getDate());
        }

    @Test
    @DisplayName("Eliminar un gasto de BD")
    public void deleteExpenseTest() throws SQLException {
        ExpenseDto expenseDto = new ExpenseDto(20000.0, "comida", "20/19/1999");
        String sql = "DELETE FROM expenses WHERE id = ?";

        expenseImplH2Mock.insert(expenseDto);

        expenseImplH2Mock.delete(expenseDto.getId());

        when(preparedStatementMock.executeUpdate()).thenReturn(1);
    }

    @Test
    @DisplayName("Obtener lista de gastos")
    public void getExpenseListTest() throws SQLException {
        List<ExpenseDto> expenseDtoList = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        expenseDtoList.add(new ExpenseDto(20000.0, "comidas", "20/10/2020"));
        expenseDtoList.add(new ExpenseDto(10000.0, "varios", "10/10/2020"));

        expenseImplH2Mock.insert(expenseDtoList.get(0));
        expenseImplH2Mock.insert(expenseDtoList.get(1));

        List<ExpenseDto> result = expenseImplH2Mock.getAllExpenses();

        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);

        for (int x = 0; x < result.size(); x++) {
            assertEquals(result.get(x).getId(), expenseDtoList.get(x).getId());
            assertEquals(result.get(x).getCategory(), expenseDtoList.get(x).getCategory());
            assertEquals(result.get(x).getAmount(), expenseDtoList.get(x).getAmount());
            assertEquals(result.get(x).getDate(), expenseDtoList.get(x).getDate());
        }
    }
    }