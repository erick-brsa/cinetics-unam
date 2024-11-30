package com.cinetics.asistente;


import com.cinetics.modelo.Pelicula;
import com.cinetics.modelo.Sucursal;
import com.cinetics.utils.Utils;

import java.util.ArrayList;

public class Rob {
    public static void saludar() {
        System.out.println("Rob: ¡Hola! Soy Rob, tu asistente virtual en CINE-TICs.");
    }

    public static void recomendarPelicula(Sucursal sucursal, ArrayList<Pelicula> peliculas) {
        System.out.println("Rob: Lo siento, no pudimos encontrar la película que estás buscando.");
        System.out.println("Rob: Puedo recomendarte la siguiente película:");
        ArrayList<Pelicula> cartelera = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (sucursal.getId().equals(pelicula.getSucursalID())) {
                cartelera.add(pelicula);
                Utils.imprimirTablaPeliculas(cartelera, sucursal.getNombre());
                return;
            }
        }
    }

    public static void registroExitoso(String id) {
        System.out.println("Rob: ¡Eso es todo! Cuenta creada exitosamente.");
        System.out.printf("Rob: Tu ID de cliente es: %s\n", id);
    }

    public static void bienvenidaInicioSesion(String nombre) {
        System.out.printf("Rob: Bienvenido %s\n", nombre);
    }
}
