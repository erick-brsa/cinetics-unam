package com.cinetics.controlador;

import com.cinetics.asistente.Rob;
import com.cinetics.modelo.Pelicula;
import com.cinetics.modelo.Sala;
import com.cinetics.modelo.Sucursal;
import com.cinetics.principal.Sistema;
import com.cinetics.utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorSucursal {
    public static ArrayList<Sucursal> obtenerSucursales() {
        ArrayList<Sucursal> sucursales = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(Sistema.RUTA_SUCURSALES);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split("-\\|-"); // Separa los campos "-|-
                String id = datos[0];
                String nombre = datos[1];
                Sala[] salas = new Sala[3];
                for (int i = 0; i < 3; i++) {
                    salas[i] = new Sala(id, i + 1, Integer.parseInt(datos[i + 2]));
                }
                sucursales.add(new Sucursal(id, nombre, salas));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sucursales;
    }

    public static void verCartelera(Sucursal sucursal, ArrayList<Pelicula> peliculas) {
        ArrayList<Pelicula> cartelera = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getSucursalID().equals(sucursal.getId())) {
                cartelera.add(pelicula);
            }
        }
        Utils.imprimirTablaPeliculas(cartelera, sucursal.getNombre());
    }

    public static void buscarPelicula(Sucursal sucursal, ArrayList<Pelicula> peliculas, String titulo) {
        ArrayList<Pelicula> cartelera = new ArrayList<>();
        boolean encontrado = false;
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().toLowerCase().contains(titulo.toLowerCase()) && sucursal.getId().equals(pelicula.getSucursalID())) {
                encontrado = true;
                cartelera.add(pelicula);
            }
        }

        if (!encontrado) {
            Rob.recomendarPelicula(sucursal, peliculas);
            return;
        }

        Utils.imprimirTablaPeliculas(cartelera, sucursal.getNombre());
    }
}
