package com.proyectoIntegrador.Expenses.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Utilidades")
class UtilitiesTest {
    @Test
    @DisplayName("Primera letra mayuscula")
    void capitalize() {
        assertEquals(Utilities.capitalize("comida"), "Comida");
        assertEquals(Utilities.capitalize("vArIoS"), "Varios");
        assertEquals(Utilities.capitalize("HERRAMIENTAS"), "Herramientas");

    }
}