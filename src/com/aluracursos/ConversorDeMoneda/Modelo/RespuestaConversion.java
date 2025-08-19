package com.aluracursos.ConversorDeMoneda.Modelo;

public record RespuestaConversion(String base_code,
                                  String target_code,
                                  double conversion_rate) {
}
