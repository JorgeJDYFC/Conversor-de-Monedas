package com.aluracursos.ConversorDeMoneda.Modelo;

public class Moneda {
    private String codigoIsoMonedaBase;
    private String codigoIsoMonedaDestino;
    private double tasaConversion;
    private double cantidad;
    private double resultadoConversion;

    public Moneda(String codigoIsoMonedaBase, String codigoIsoMonedaDestino, double tasaConversion, double cantidad) {
        this.codigoIsoMonedaBase = codigoIsoMonedaBase;
        this.codigoIsoMonedaDestino = codigoIsoMonedaDestino;
        this.tasaConversion = tasaConversion;
        this.cantidad = cantidad;
        this.resultadoConversion = tasaConversion * cantidad;
    }

    public String getCodigoIsoMonedaBase() {
        return codigoIsoMonedaBase;
    }

    public String getCodigoIsoMonedaDestino() {
        return codigoIsoMonedaDestino;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }

    @Override
    public String toString() {
        return String.format(
                "%.2f %s equivale a %.2f %s (Tasa: %.4f)",
                cantidad,
                codigoIsoMonedaBase,
                resultadoConversion,
                codigoIsoMonedaDestino,
                tasaConversion);
    }
}
