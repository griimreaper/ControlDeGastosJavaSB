package com.proyectoIntegrador.Expenses.service.impl;

import com.proyectoIntegrador.Expenses.model.ExpenseCategory;
import com.proyectoIntegrador.Expenses.repository.impl.ExpenseCategoryImplh2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.*;

@DisplayName("Test de Servicio Categoria")
class ExpenseCategoryServiceImplTest {
    @Mock
    ExpenseCategory expenseCategoryMock;
    @Mock
    ExpenseCategoryImplh2 expenseCategoryImplh2Mock;
    @InjectMocks
    ExpenseCategoryServiceImpl expenseCategoryServiceMock;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        expenseCategoryMock = new ExpenseCategory();
    }
    @Test
    @DisplayName("Insertar una Categoria")
    void insert() {
        String name = "Comida";

        expenseCategoryServiceMock.insert(name);

        verify(expenseCategoryImplh2Mock).insert(isNotNull());
    }

    @Test
    @DisplayName("Actualizar una Categoria")
    void update() {
        String id = "idFalso";
        String name = "Comida";

        expenseCategoryServiceMock.update(name, id);

        verify(expenseCategoryImplh2Mock).update(name, id);
    }

    @Test
    @DisplayName("Eliminar una Categoria")
    void delete() {
        String id = "idFalso";
        expenseCategoryMock.setId(id);
        expenseCategoryImplh2Mock.insert(expenseCategoryMock);
        expenseCategoryServiceMock.delete(id);

        verify(expenseCategoryImplh2Mock).delete(id);
    }

    @Test
    @DisplayName("Obtener Categoria por id")
    void getCategoryById() {
        String id = "idFalso";
        expenseCategoryMock.setId(id);
        expenseCategoryImplh2Mock.insert(expenseCategoryMock);
        expenseCategoryServiceMock.getCategoryById(id);

        verify(expenseCategoryImplh2Mock).getCategoryById(id);
    }

    @Test
    @DisplayName("Obtener todas las categorias")
    void getAllCategories() {
        expenseCategoryServiceMock.getAllCategories();

        verify(expenseCategoryImplh2Mock).getAllCategories();
    }

    @Test
    @DisplayName("Contador de categorias")
    void countCategories() {
        expenseCategoryServiceMock.countCategories();

        verify(expenseCategoryImplh2Mock).getAllCategories();
    }
}