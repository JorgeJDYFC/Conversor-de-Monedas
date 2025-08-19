package com.aluracursos.ConversorDeMoneda.Servicio;

public class Menu {
    public static void mostrarMenuPrincipal() {
        System.out.println("""
                *****************************=====MENU=====*****************************
                           INGRESA EL NUMERO DE LA OPCION QUE QUIERAS USAR.
                1.-Consulta el valor de una moneda en otras monedas.
                2.-Realizar la conversion entre dos monedas.
                3.-Consulta la equivalencia de una moneda con las disponibles en la API.
                4.-Ver todas las consultas realizadas en esta aplicacion (si existen).
                5.-Salir
                **************************************************************************""");
    }

    public static void mostrarMonedasDisponibles() {
        System.out.println("""
                Las monedas disponibles para esta opción son las siguientes:
                -Dólar (USD)
                -Peso Mexicano (MXN)
                -Real Brasileño (BRL)
                -Peso Argentino (ARS)
                -Peso Colombiano (COP)
                -Euro (EUR)
                -Yen Japonés (JPY)
                -Libra Esterlina (GBP)
                -Franco Suizo (CHF)
                -Dólar Canadiense (CAD)""");
    }
}

