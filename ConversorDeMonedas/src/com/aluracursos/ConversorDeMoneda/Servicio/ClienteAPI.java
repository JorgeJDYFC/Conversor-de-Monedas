package com.aluracursos.ConversorDeMoneda.Servicio;

import com.aluracursos.ConversorDeMoneda.Modelo.Moneda;
import com.aluracursos.ConversorDeMoneda.Modelo.RespuestaConversion;
import com.aluracursos.ConversorDeMoneda.Modelo.RespuestaTodasTasas;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ClienteAPI {

        String llaveApi = "5f305948ee30de0e03a3a79d";
        public Moneda convertirMoneda(String codigoIsoMonedaBase, String codigoIsoMonedaDestino, double cantidad) {
                String direccion = "https://v6.exchangerate-api.com/v6/"+llaveApi+"/pair/"
                        + codigoIsoMonedaBase + "/" + codigoIsoMonedaDestino;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
        try{
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                Gson gson = new Gson();
                RespuestaConversion datos = gson.fromJson(response.body(), RespuestaConversion.class);

                return new Moneda(
                        datos.base_code(),
                        datos.target_code(),
                        datos.conversion_rate(),
                        cantidad
                );

        } catch (Exception e) {
                System.out.println("Error al conectar con la API: " + e.getMessage());
                return null;
        }
        }

        public Map<String, Double> obtenerTodasLasTasas(String codigoIsoMonedaBase) {
                String url = "https://v6.exchangerate-api.com/v6/"+llaveApi+"/latest/" + codigoIsoMonedaBase;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                        Gson gson = new Gson();
                        RespuestaTodasTasas respuesta = gson.fromJson(response.body(), RespuestaTodasTasas.class);

                        return respuesta.conversion_rates();

                } catch (Exception e) {
                        System.out.println("Error al obtener tasas: " + e.getMessage());
                        return null;
                }
        }


}