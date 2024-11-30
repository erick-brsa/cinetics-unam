package com.cinetics.utils;

import com.cinetics.modelo.Pelicula;
import com.cinetics.modelo.Producto;
import com.cinetics.modelo.Sucursal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Utils {
    public static String generarID() {
        String fecha = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return "ID-" + fecha + "-" + uuid;
    }

    public static void imprimirTablaPeliculas(ArrayList<Pelicula> peliculas, String nombreSucursal) {
        // Encabezados
        String header = String.format("| %-25s | %-8s | %-40s | %-8s | %-10s | %-15s | %-4s | %-5s |",
                "Título", "Clasif.", "Director", "Duración", "Sucursal", "Horario", "Sala", "Disp.");
        String separator = "-".repeat(header.length());

        // Mostrar tabla
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);

        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.informacionCartelera(nombreSucursal));
        }

        System.out.println(separator);
    }

    public static void imprimirTablaProductos(ArrayList<Producto> productos) {
        // Encabezados
        String header = String.format("| %-20s | %-15s | %-8s | %-15s | %-10s | %-15s | %-10s | %-15s |",
                "Nombre", "Código Producto", "Precio", "Categoría", "Stock CU", "Stock Universidad", "Stock Delta", "Stock Xochimilco");
        String separator = "-".repeat(header.length());

        // Mostrar tabla
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);

        for (Producto producto : productos) {
            System.out.println(producto.informacionProducto());
        }

        System.out.println(separator);
    }


    public static String leerCadena(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        System.out.print(mensaje);
        entrada = scanner.nextLine();
        return entrada;
    }

    public static int leerEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;
        int numero = 0;
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("¡Entrada no válida! Por favor, ingresa un número entero.");
            }
        }
        return numero;
    }

    public static float leerFlotante(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        boolean esValido = false;
        float numero = 0;
        while (!esValido) {
            System.out.print(mensaje);
            try {
                numero = Float.parseFloat(scanner.nextLine());
                esValido = true;
            } catch (NumberFormatException e) {
                System.out.println("¡Entrada no válida! Por favor, ingresa un número.");
            }
        }
        return numero;
    }
}
