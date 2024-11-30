package com.cinetics.controlador;

import com.cinetics.modelo.Producto;
import com.cinetics.principal.Sistema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorProductos {
    public static ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(Sistema.RUTA_PRODUCTOS);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split("-\\|-"); // Separa los campos "-|-"
                String nombre = datos[1];
                String codigo = datos[2];
                int precio = Integer.parseInt(datos[3]);
                String categoria = datos[4];
                int stockCU = Integer.parseInt(datos[5]);
                int stockUniversidad = Integer.parseInt(datos[6]);
                int stockDelta = Integer.parseInt(datos[7]);
                int stockXochimilco = Integer.parseInt(datos[8]);
                productos.add(new Producto(nombre, codigo, precio, categoria, stockCU, stockUniversidad, stockDelta, stockXochimilco));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }
}
