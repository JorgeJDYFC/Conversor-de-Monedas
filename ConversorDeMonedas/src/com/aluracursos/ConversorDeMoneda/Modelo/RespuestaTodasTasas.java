package com.aluracursos.ConversorDeMoneda.Modelo;

import java.util.Map;

public class RespuestaTodasTasas {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getters necesarios

    public String result() {
        return result;
    }

    public String base_code() {
        return base_code;
    }

    public Map<String, Double> conversion_rates() {
        return conversion_rates;
    }
}
