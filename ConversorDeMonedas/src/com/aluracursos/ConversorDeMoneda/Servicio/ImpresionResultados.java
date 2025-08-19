package com.aluracursos.ConversorDeMoneda.Servicio;

import com.aluracursos.ConversorDeMoneda.Modelo.Moneda;

import java.util.Map;

public class ImpresionResultados {

    public static void mostrarTasas(String base, Map<String, Double> tasas) {
        if (tasas != null) {
            System.out.println("\n=== Equivalencias para 1" + base + " ===");

            tasas.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        String codigo = entry.getKey();
                        double valor = entry.getValue();
                        System.out.println(base + " → " + codigo + ": " + String.format("%.2f", valor));
                    });
        } else {
            System.out.println("No se pudo obtener la información.");
        }
    }
    public static void mostrarConversion(Moneda moneda) {
        if (moneda != null) {
            System.out.println("\n=== Resultado de conversión ===");
            System.out.println(moneda);
        } else {
            System.out.println("No se pudo realizar la conversión.");
        }
    }
}
