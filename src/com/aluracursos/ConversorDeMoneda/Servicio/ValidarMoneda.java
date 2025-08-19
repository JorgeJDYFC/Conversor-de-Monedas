package com.aluracursos.ConversorDeMoneda.Servicio;

import java.util.List;

public class ValidarMoneda {
    private static final List<String> MONEDAS_VALIDAS = List.of(
            "USD", "MXN", "BRL", "ARS", "COP", "EUR", "JPY", "GBP", "CHF", "CAD"
    );

    public static boolean esMonedaValida(String codigoIso) {
        return MONEDAS_VALIDAS.contains(codigoIso.toUpperCase());
    }

    public static List<String> obtenerMonedasValidas() {
        return MONEDAS_VALIDAS;
    }
}
