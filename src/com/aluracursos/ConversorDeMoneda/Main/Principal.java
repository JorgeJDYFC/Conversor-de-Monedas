package com.aluracursos.ConversorDeMoneda.Main;

import com.aluracursos.ConversorDeMoneda.Modelo.Moneda;
import com.aluracursos.ConversorDeMoneda.Servicio.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteAPI clienteAPI = new ClienteAPI();

        boolean continuar = true;

        while (continuar) {
            Menu.mostrarMenuPrincipal();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    Menu.mostrarMonedasDisponibles();
                    String base = EntradaUsuario.leerCodigoISO("Ingrese el código ISO de la moneda base disponibles en el menu: ");
                    double cantidad = EntradaUsuario.leerCantidad("Ingrese la cantidad a convertir: ");

                    System.out.println("Conversion de " + cantidad + " " + base + " a las demás monedas:");
                    for (String destino : com.aluracursos.ConversorDeMoneda.Servicio.ValidarMoneda.obtenerMonedasValidas()) {
                        if (!destino.equals(base)) {
                            Moneda resultado = clienteAPI.convertirMoneda(base, destino, cantidad);
                            ImpresionResultados.mostrarConversion(resultado);
                            Historial.guardarConversion(resultado);
                        }
                    }
                }

                case "2" -> {
                    Menu.mostrarMonedasDisponibles();
                    String base = EntradaUsuario.leerMoneda("Ingrese el alias o código ISO de la moneda base: ");
                    String destino = EntradaUsuario.leerMoneda("Ingrese el alias o código ISO de la moneda destino: ");
                    double cantidad = EntradaUsuario.leerCantidad("Ingrese la cantidad a convertir: ");

                    Moneda resultado = clienteAPI.convertirMoneda(base, destino, cantidad);
                    ImpresionResultados.mostrarConversion(resultado);
                    Historial.guardarConversion(resultado);
                }

                case "3" -> {
                    Menu.mostrarMonedasDisponibles();
                    String base = EntradaUsuario.leerMoneda("Ingrese el codigo ISO de la moneda que quieras consultar: ");
                    Map<String, Double> tasas = clienteAPI.obtenerTodasLasTasas(base);
                    ImpresionResultados.mostrarTasas(base, tasas);
                }

                case "4" -> {
                    System.out.println("Este es su historial de consultas:");
                    List<Moneda> historial = Historial.leerHistorial();
                    if (historial.isEmpty()) {
                        System.out.println("Historial vacio.");
                    } else {
                        historial.forEach(m -> System.out.printf("%s → %s | Tasa: %.4f | Cantidad: %.2f%n",
                                m.getCodigoIsoMonedaBase(), m.getCodigoIsoMonedaDestino(), m.getTasaConversion(), m.getCantidad()));
                    }
                }

                case "5" -> {
                    continuar = false;
                    System.out.println("Gracias por usar esta aplicacion.");
                }

                default -> System.out.println("Opción inválida. Por favor, seleccione con numeros entre 1 y 5.");
            }
        }

        scanner.close();
    }
}