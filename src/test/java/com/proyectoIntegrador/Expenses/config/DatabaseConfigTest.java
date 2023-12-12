package com.proyectoIntegrador.Expenses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfigTest {
    @Bean
    public Connection getDBConnection() throws SQLException {
        // Configura y devuelve la conexión a tu base de datos H2
        return DriverManager.getConnection("jdbc:h2:~/expensesDBTest", "Leonelaxl", "");
    }
}