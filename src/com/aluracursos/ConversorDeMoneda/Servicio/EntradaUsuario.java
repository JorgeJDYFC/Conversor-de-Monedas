package com.aluracursos.ConversorDeMoneda.Servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EntradaUsuario {
    private static final Map<String, String> aliasAMoneda = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        aliasAMoneda.put("dolar", "USD");
        aliasAMoneda.put("usd", "USD");

        aliasAMoneda.put("peso ", "MXN");
        aliasAMoneda.put("mxn", "MXN");

        aliasAMoneda.put("real brasileño", "BRL");
        aliasAMoneda.put("real", "BRL");
        aliasAMoneda.put("brl", "BRL");

        aliasAMoneda.put("peso argentino", "ARS");
        aliasAMoneda.put("ars", "ARS");

        aliasAMoneda.put("peso colombiano", "COP");
        aliasAMoneda.put("cop", "COP");

        aliasAMoneda.put("euro", "EUR");
        aliasAMoneda.put("eur", "EUR");

        aliasAMoneda.put("yen", "JPY");
        aliasAMoneda.put("yen japones", "JPY");
        aliasAMoneda.put("jpy", "JPY");

        aliasAMoneda.put("libra", "GBP");
        aliasAMoneda.put("libra esterlina", "GBP");
        aliasAMoneda.put("gbp", "GBP");

        aliasAMoneda.put("franco", "CHF");
        aliasAMoneda.put("franco suizo", "CHF");
        aliasAMoneda.put("chf", "CHF");

        aliasAMoneda.put("dolar canadiense", "CAD");
        aliasAMoneda.put("cad", "CAD");
    }

    public static String leerMoneda(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (aliasAMoneda.containsKey(entrada)) {
                return aliasAMoneda.get(entrada);
            } else {
                System.out.println("Moneda no válida. Intente con un nombre o código ISO reconocido.");
            }
        }
    }

    public static double leerCantidad(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Cantidad no válida. Ingrese un número válido.");
            }
        }
    }

    public static String leerCodigoISO(String mensaje) {
            while (true) {
                System.out.print(mensaje);
                String codigo = scanner.nextLine().trim().toUpperCase();

                if (ValidarMoneda.esMonedaValida(codigo)) {
                    return codigo;
                } else {
                    System.out.println("Código inválido. Debe ser uno de: " + ValidarMoneda.obtenerMonedasValidas());
                }
            }
    }

}
