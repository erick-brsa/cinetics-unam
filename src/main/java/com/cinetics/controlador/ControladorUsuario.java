package com.cinetics.controlador;

import com.cinetics.asistente.Rob;
import com.cinetics.modelo.Cliente;
import com.cinetics.modelo.Empleado;
import com.cinetics.modelo.Usuario;
import com.cinetics.principal.Sistema;
import com.cinetics.utils.Utils;

import java.io.*;
import java.util.ArrayList;

public class ControladorUsuario {

    private static ArrayList<Cliente> clientes = obtenerClientes();
    private static ArrayList<Empleado> empleados = obtenerEmpleados();

    private static ArrayList<Cliente> obtenerClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(Sistema.RUTA_CLIENTES);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split("-\\|-");
                String id = datos[0];
                String nombre = datos[1];
                String primerApellido = datos[2];
                String segundoApellido = datos[3];
                String direccion = datos[4];
                String telefono = datos[5];
                String rfc = datos[6];
                String direccionFiscal = datos[7];
                String email = datos[8];
                String password = datos[9];
                int nivel = Integer.parseInt(datos[10]);
                int puntos = Integer.parseInt(datos[11]);

                clientes.add(new Cliente(id, nombre, primerApellido, segundoApellido, direccion, telefono, rfc, direccionFiscal, email, password, nivel, puntos));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    private static ArrayList<Empleado> obtenerEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(Sistema.RUTA_EMPLEADOS);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split("-\\|-");
                String id = datos[0];
                String nombre = datos[1];
                String primerApellido = datos[2];
                String segundoApellido = datos[3];
                String direccion = datos[4];
                String telefono = datos[5];
                String rfc = datos[6];
                String direccionFiscal = datos[7];
                String email = datos[8];
                String password = datos[9];
                String rol = datos[10];
                String sucursal = datos[11];

                empleados.add(new Empleado(id, nombre, primerApellido, segundoApellido, direccion, telefono, rfc, direccionFiscal, email, password, rol, sucursal));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return empleados;
    }

    public static Usuario buscarUsuario(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        for (Empleado empleado : empleados) {
            if (empleado.getEmail().equals(email)) {
                return empleado;
            }
        }
        return null;
    }

    public static void iniciarSesion() {

        String correo = Utils.leerCadena("Ingrese su correo electrónico: ");
        String password = Utils.leerCadena("Ingrese su contraseña: ");

        Usuario usuario = buscarUsuario(correo);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        if (!password.equals(usuario.getPassword())) {
            System.out.println("Contraseña incorrecta.");
            return;
        }

        Rob.bienvenidaInicioSesion(usuario.getNombre());
        Sistema.usuario = usuario;
    }

    public static void registrarse() {
        String nombre = Utils.leerCadena("Ingrese su nombre: ");
        String primerApellido = Utils.leerCadena("Ingrese su apellido paterno: ");
        String segundoApellido = Utils.leerCadena("Ingrese su apellido materno: ");
        String direccion = Utils.leerCadena("Ingrese su dirección: ");
        String telefono = Utils.leerCadena("Ingrese su teléfono: ");
        String email = Utils.leerCadena("Ingrese su correo electrónico: ");

        while (buscarUsuario(email) != null) {
            System.out.println("El correo ya está registrado.");
            email = Utils.leerCadena("Ingrese su correo electrónico: ");
        }

        String password = Utils.leerCadena("Ingrese su password: ");

        while (password.length() < 6) {
            System.out.println("El password debe tener al menos 6 caracteres.");
            password = Utils.leerCadena("Ingrese su password: ");
        }

        String eleccion = Utils.leerCadena("Te gustaría leer más? (y/n): ");

        while (!(eleccion.equals("y") || eleccion.equals("n"))) {
            System.out.println("Opción no válida.");
            eleccion = Utils.leerCadena("Desea suscribirse a este programa? (y/n): ");
        }

        if (eleccion.equals("y")) {
            System.out.println("Programa de Lealtad");
            System.out.println("3% en puntos para el nivel 0.");
            System.out.println("7.5% en puntos para el nivel 5.");
            System.out.println("15% en puntos para el nivel 10.");
            System.out.println("Cada punto vale $0.0027");
            System.out.println("Actualmente eres nivel 0.");
            System.out.printf("%-15s %-20s\n", "Nivel", "Requisitos");
            System.out.printf("%-15s %-20s\n", "0 a 5", "Sube a los $1,000 de compra.");
            System.out.printf("%-15s %-20s\n", "5 a 10", "Sube a los $1,200 de compra.");
            System.out.printf("%-15s %-20s\n", "10 a 15", "Sube a los $1,350 de compra.");
            System.out.printf("%-15s %-20s\n", "15", "Cada $500 recibe un programa aleatorio.");
        }

        Cliente nuevo = new Cliente(nombre, primerApellido, segundoApellido, direccion, telefono, email, password);
        Sistema.usuario = nuevo;
        clientes.add(nuevo);

        Rob.registroExitoso(nuevo.getId());
        guardarCliente(nuevo);
    }

    public static void actualizarDatosPersonales() {
        System.out.println("¿Qué deseas actualizar?");
        String[] opciones = {"Nombre", "Primer apellido", "Segundo apellido", "Dirección", "Telefono", "Email", "Password", "Cancelar"};
        for (int i = 1; i <= opciones.length; i++) {
            System.out.printf("%d. %s\n", i, opciones[i - 1]);
        }
        int opcion = Utils.leerEntero("Seleccione una opcion: ");
        switch (opcion) {
            case 1 -> {
                String nombre = Utils.leerCadena("Ingrese su nombre: ");
                Sistema.usuario.setNombre(nombre);
            }
            case 2 -> {
                String primerApellido = Utils.leerCadena("Ingrese su primer apellido: ");
                Sistema.usuario.setPrimerApellido(primerApellido);
            }
            case 3 -> {
                String segundoApellido = Utils.leerCadena("Ingrese su segundo apellido: ");
                Sistema.usuario.setSegundoApellido(segundoApellido);
            }
            case 4 -> {
                String direccion = Utils.leerCadena("Ingrese su dirección: ");
                Sistema.usuario.setDireccion(direccion);
            }
            case 5 -> {
                String telefono = Utils.leerCadena("Ingrese su teléfono: ");
                Sistema.usuario.setTelefono(telefono);
            }
            case 6 -> {
                String email = Utils.leerCadena("Ingrese su correo electrónico: ");
                while (buscarUsuario(email) != null) {
                    System.out.println("El correo ya está registrado.");
                    email = Utils.leerCadena("Ingrese su correo electrónico: ");
                }
                Sistema.usuario.setEmail(email);
            }
            case 7 -> {
                String password = Utils.leerCadena("Ingrese su password: ");
                while (password.length() < 6) {
                    System.out.println("El password debe tener al menos 6 caracteres.");
                    password = Utils.leerCadena("Ingrese su password: ");
                }
                Sistema.usuario.setPassword(password);
            }
            case 8 -> {}
            default -> {
                System.out.println("Opción no válida");
            }
        }
    }

    public static void actualizarArchivoClientes() {

    }

    private static void guardarCliente(Cliente cliente) {
        try (FileWriter escritor = new FileWriter(Sistema.RUTA_CLIENTES, true)) {
            escritor.write(cliente.toString());
            System.out.println("Agregado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}
