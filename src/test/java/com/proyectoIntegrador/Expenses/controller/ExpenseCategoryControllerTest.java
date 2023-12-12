package com.proyectoIntegrador.Expenses.controller;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.service.ExpenseCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Test De Controladores De Categorias.")
class ExpenseCategoryControllerTest {
    @Mock
    ExpenseCategory expenseCategoryMock;
    @Mock
    ExpenseCategoryService expenseCategoryServiceMock;
    @InjectMocks
    ExpenseCategoryController expenseCategoryControllerMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Obtener todas las categorias.")
    void getCategories() {
        List<ExpenseCategory> result = expenseCategoryControllerMock.getCategories();
        when(expenseCategoryServiceMock.getAllCategories()).thenReturn(result);
        verify(expenseCategoryServiceMock).getAllCategories();
    }

    @Test
    @DisplayName("Obtener categoria por id.")
    void getCategoryById() {
        String id = "idFalso";

        ExpenseCategory result = expenseCategoryControllerMock.getCategoryById(id);

        when(expenseCategoryControllerMock.getCategoryById(id)).thenReturn(result);
        verify(expenseCategoryServiceMock).getCategoryById(id);
    }

    @Test
    void insertCategory() {
        expenseCategoryControllerMock.insertCategory(expenseCategoryMock);

        verify(expenseCategoryServiceMock).insert(expenseCategoryMock.getId());
    }

    @Test
    @DisplayName("Actualizar categoria.")
    void updateCategory() {
        String id = "idFalso";

        expenseCategoryControllerMock.updateCategory(expenseCategoryMock, id);
    }

    @Test
    @DisplayName("Eliminar una categoria.")
    void deleteCategory() {
        String id = "idFalso";

        expenseCategoryControllerMock.deleteCategory(id);

        verify(expenseCategoryServiceMock).delete(id);
    }

    @Test
    @DisplayName("Obtener contador de categorias")
    void countCategories() {
        Map<String,Integer> result = expenseCategoryControllerMock.countCategories();

        when(expenseCategoryServiceMock.countCategories()).thenReturn(result);
        verify(expenseCategoryServiceMock).countCategories();
    }
}