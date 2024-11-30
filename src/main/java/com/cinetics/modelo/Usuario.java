package com.cinetics.modelo;

import com.cinetics.utils.Utils;

public abstract class Usuario {
    private final String id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String telefono;
    private String rfc;
    private String direccionFiscal;
    private String email;
    private String password;

    public Usuario(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String email, String password) {
        this.id = Utils.generarID();
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Usuario(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String rfc, String email, String password) {
        this.id = Utils.generarID();
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rfc = rfc;
        this.email = email;
        this.password = password;
    }

    public Usuario(String id, String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String rfc, String direccionFiscal, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rfc = rfc;
        this.direccionFiscal = direccionFiscal;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s-|-%s-|-%s-|-%s-|-%s-|-%s-|-%s-|-%s-|-%s-|-%s",
                id, nombre, primerApellido, segundoApellido, direccion, telefono, rfc, direccionFiscal, email, password);
    }
}
