package com.cinetics.principal;

import com.cinetics.carrito.Carrito;
import com.cinetics.controlador.ControladorPeliculas;
import com.cinetics.controlador.ControladorSucursal;

import com.cinetics.controlador.ControladorUsuario;
import com.cinetics.modelo.*;
import com.cinetics.utils.Utils;

import java.util.ArrayList;

public class Sistema {

    public static final String RUTA_CAJA = "src/main/resources/caja.txt";
    public static final String RUTA_VENTAS = "src/main/resources/ventas.txt";
    public static final String RUTA_CLIENTES = "src/main/resources/clientes.txt";
    public static final String RUTA_PRODUCTOS = "src/main/resources/producos.txt";
    public static final String RUTA_EMPLEADOS = "src/main/resources/empleados.txt";
    public static final String RUTA_PELICULAS = "src/main/resources/peliculas.txt";
    public static final String RUTA_SUCURSALES = "src/main/resources/sucursales.txt";

    public static Usuario usuario = null;
    public static Sucursal sucursal = null;
    public static ArrayList<Sucursal> sucursales = ControladorSucursal.obtenerSucursales();
    public static ArrayList<Pelicula> peliculas = ControladorPeliculas.obtenerPeliculas();

    public static final String[] opcionesInvitado = {"Ver cartelera", "Buscar película", "Cambiar sucursal", "Dulcería", "Ver carrito", "Iniciar sesión", "Registrarse", "Acerda del equipo", "Salir"};
    public static final String[] opcionesSocio = {"Ver cartelera", "Buscar película", "Cambiar sucursal", "Dulcería", "Ver carrito", "Actualizar datos personales", "Ver mis compras", "Ver mis puntos", "Acerca del equipo", "Cerrar sesión"};
    public static final String[] opcionesEmpleado = {"Entrega de alimentos", "Consultar a Rob", "Salir"};
    public static final String[] opcionesGerente = {"Ver estadísticas del negocio", "Consultar a Rob", "Salir"};
    public static final String[] opcionesAdministrador = {"Actualizar cartelera", "Ver productos", "Actualizar stock de productos", "Agregar producto", "Ver empleados", "Agregar empleados", "Ver estadísticas de ventas", "Generar reporte de ventas", "Salir"};
    public static String[] opciones = opcionesInvitado;

    public static final int COSTO_BOLETO_MAYOR = 80;
    public static final int COSTO_BOLETO_MENOR = 50;

    public static void imprimirMenuSucursales() {
        if (sucursales.isEmpty()) {
            System.out.printf("%d. Salir\n", 1);
            return;
        }
        for (int i = 1; i <= sucursales.size(); i++) {
            System.out.printf("%d. %s\n", i, sucursales.get(i - 1).getNombre());
        }
    }

    public static void imprimirMenu() {
        if (usuario instanceof Empleado && ((Empleado) usuario).getRol().equals("administrador")) {
            opciones = opcionesAdministrador;
        }

        if (usuario instanceof Empleado && ((Empleado) usuario).getRol().equals("empleado")) {
            opciones = opcionesEmpleado;
        }

        if (usuario instanceof Empleado && ((Empleado) usuario).getRol().equals("gerente")) {
            opciones = opcionesGerente;
        }

        if (usuario instanceof Cliente) {
            opciones = opcionesSocio;
        }

        if (usuario == null) {
            opciones = opcionesInvitado;
        }

        System.out.printf("Sucursal %s\n", sucursal.getNombre());
        for (int i = 1; i <= opciones.length; i++) {
            System.out.printf("%d. %s\n", i, opciones[i - 1]);
        }
    }

    public static void imprimirMenuDulceria() {
        // TODO: Programar cuerpo

    }

    public static void imprimirMenuCarrito() {
        /*
          TODO: Programar cuerpo
               a. Ver carrito (Editar)
               b. Comprar
         */
    }

    public static boolean validarSucursal(int cambioSucursal) {
        if (cambioSucursal < 1 || cambioSucursal > sucursales.size()) {
            return true;
        }

        sucursal = sucursales.get(cambioSucursal - 1);
        return false;
    }

    public static void cambiarSucursal() {
        imprimirMenuSucursales();
        while (true) {
            int cambioSucursal = Utils.leerEntero("Seleccione una sucursal: ");
            if (validarSucursal(cambioSucursal)) {
                System.out.println("Opción no válida.");
                continue;
            }
            break;
        }
    }

    public static void validarOpcion(int opcion) {
        if (usuario == null) {
            validarOpcionInvitado(opcion);
        }

        if (usuario instanceof Cliente) {
            validarOpcionSocio(opcion);
        }

        if (usuario instanceof Empleado && ((Empleado) usuario).getRol().equals("empleado")) {
            validarOpcionEmpleado(opcion);
        }

        if (usuario instanceof Empleado && ((Empleado) usuario).getRol().equals("gerente")) {
            validarOpcionGerente(opcion);
        }

        if (usuario instanceof Empleado && ((Empleado) usuario).getRol().equals("admin")) {
            validarOpcionAdministrador(opcion);
        }
    }

    public static void validarOpcionInvitado(int opcion) {
        switch (opcion) {
            case 1 -> {
                ControladorSucursal.verCartelera(sucursal, peliculas);
            }
            case 2 -> {
                String titulo = Utils.leerCadena("Introduce el titulo de la película que buscas: ");
                ControladorSucursal.buscarPelicula(sucursal, peliculas, titulo);
            }
            case 3 -> {
                cambiarSucursal();
            }
            case 4 -> {
                imprimirMenuDulceria();
            }
            case 5 -> {
                imprimirMenuCarrito();
            }
            case 6 -> {
                ControladorUsuario.iniciarSesion();
            }
            case 7 -> {
                ControladorUsuario.registrarse();
            }
            case 8 -> {
                acercaDelEquipo();
            }
            case 9 -> {
                Carrito.boletos = new ArrayList<>();
                Carrito.productos = new ArrayList<>();
                System.exit(0);
            }
            default -> {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void validarOpcionSocio(int opcion) {
        switch (opcion) {
            case 1 -> {
                ControladorSucursal.verCartelera(sucursal, peliculas);
            }
            case 2 -> {
                String titulo = Utils.leerCadena("Introduce el titulo de la película que buscas: ");
                ControladorSucursal.buscarPelicula(sucursal, peliculas, titulo);
            }
            case 3 -> {
                cambiarSucursal();
            }
            case 4 -> {
                imprimirMenuDulceria();
            }
            case 5 -> {
                imprimirMenuCarrito();
            }
            case 6 -> {
                ControladorUsuario.actualizarDatosPersonales();
            }
            case 7 -> {
                acercaDelEquipo();
            }
            case 8 -> {
                Carrito.boletos = new ArrayList<>();
                Carrito.productos = new ArrayList<>();
                usuario = null;
            }
            default -> {
                System.out.println("Opcion no válida.");
            }
        }
    }

    public static void validarOpcionEmpleado(int opcion) {
        switch (opcion) {
            case 1 -> {
                // TODO: Entrega de alimentos
            }
            case 2 -> {
                // TODO: Cerrar sesión
            }
            default -> {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void validarOpcionGerente(int opcion) {
        switch (opcion) {
            case 1 -> {
                // TODO: Entrega de alimentos
            }
            case 2 -> {
                // TODO: Cerrar sesión
            }
            default -> {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void validarOpcionAdministrador(int opcion) {
        switch (opcion) {
            case 1 -> {
                // TODO: Actualizar cartelera
            }
            case 2 -> {
                // TODO: Ver productos
            }
            case 3 -> {
                // TODO: Actualizar stock de productos
            }
            case 4 -> {
                // TODO: Agregar producto
            }
            case 5 -> {
                // TODO: Ver empleados
            }
            case 6 -> {
                // TODO: Agregar empleados
            }
            case 7 -> {
                // TODO: Ver estadísticas de ventas
                /**
                 * a. Por sucursal
                 * b. Por función
                 * c. Por producto
                 * d. Totales
                 * e. Regresar
                 */
            }
            case 8 -> {
                // TODO: Generar reporte de ventas
                /**
                 * a. Por sucursal
                 * b. Por función
                 * c. Por producto
                 * d. Totales
                 */
            }
            case 9 -> {
                // TODO: Modo de simulación
            }
            case 10 -> {
                usuario = null;
            }
            default -> {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void acercaDelEquipo() {
        System.out.println("Proyecto Final");
        System.out.println("Programación Orientada a Objetos");
        System.out.println("Grupo: 09");
        System.out.println("Equipo: NOMBRE DEL EQUIPO");
        System.out.println("Integrantes:");
        System.out.println("1. Briones Sánchez Erick Alan");
        System.out.println("2. Marah");
        System.out.println("3. Alex");
    }
}
