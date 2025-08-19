package com.aluracursos.ConversorDeMoneda.Servicio;

import com.aluracursos.ConversorDeMoneda.Modelo.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private static final String RUTA_ARCHIVO = "historial.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarConversion(Moneda moneda) {
        List<Moneda> historial = leerHistorial();
        historial.add(moneda);

        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    public static List<Moneda> leerHistorial() {
        try (FileReader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<List<Moneda>>() {}.getType();
            List<Moneda> historial = gson.fromJson(reader, listType);
            return historial != null ? historial : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>(); // Si no existe el archivo, devolvemos lista vacía
        }
    }
}
