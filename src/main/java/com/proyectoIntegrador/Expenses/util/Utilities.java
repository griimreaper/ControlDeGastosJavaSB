package com.proyectoIntegrador.Expenses.util;

import java.util.List;

public class Utilities {
    public static <T> void printElements(List<T> list){
        for (T element: list) {
            System.out.println(element);
            System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
        }
    };
    public static String capitalize(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
