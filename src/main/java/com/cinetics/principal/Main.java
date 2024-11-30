package com.cinetics.principal;

import com.cinetics.asistente.Rob;
import com.cinetics.utils.Utils;

public class Main {
    public static void main(String[] args) {

        int sucursal;
        int opcion = 0;

        Rob.saludar();

        while (true) {
            Sistema.imprimirMenuSucursales();
            System.out.printf("%d. Salir\n", Sistema.sucursales.size() + 1);
            sucursal = Utils.leerEntero("Seleccione una sucursal para comenzar: ");

            if (sucursal == Sistema.sucursales.size() + 1) {
                System.out.println("Bye.");
                break;
            }

            if (Sistema.validarSucursal(sucursal)) {
                System.out.println("Opción no válida.");
                continue;
            }

            while (opcion != Sistema.opciones.length) {
                Sistema.imprimirMenu();
                opcion = Utils.leerEntero("Seleccione una opcion: ");
                Sistema.validarOpcion(opcion);
            }
        }
    }
}