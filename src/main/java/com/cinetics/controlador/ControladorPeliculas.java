package com.cinetics.controlador;

import com.cinetics.modelo.Pelicula;
import com.cinetics.principal.Sistema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorPeliculas {
    public static ArrayList<Pelicula> obtenerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(Sistema.RUTA_PELICULAS);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split("-\\|-"); // Separa los campos "-|-"
                String id = datos[0];
                String titulo = datos[1];
                String clasificacion = datos[2];
                String director = datos[3];
                int duracion = Integer.parseInt(datos[4]);
                String[] actores = datos[5].split(",");
                String sinopsis = datos[6];
                String horario = datos[7];
                String sucursalID = datos[8];
                int sala = Integer.parseInt(datos[9]);
                int disponibilidad = Integer.parseInt(datos[10]);
                peliculas.add(new Pelicula(id, titulo, clasificacion, director, duracion, actores, sinopsis, horario, sucursalID, sala, disponibilidad));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return peliculas;
    }
}
