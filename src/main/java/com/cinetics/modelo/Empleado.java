package com.cinetics.modelo;

public class Empleado extends Usuario {
    private String rol;
    private String sucursal;

    public Empleado(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String rfc, String email, String password, String rol, String sucursal) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, rfc, email, password);
        this.rol = rol;
        this.sucursal = sucursal;
    }

    public Empleado(String id, String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String rfc, String direccionFiscal, String email, String password, String rol, String sucursal) {
        super(id, nombre, primerApellido, segundoApellido, direccion, telefono, rfc, direccionFiscal, email, password);
        this.rol = rol;
        this.sucursal = sucursal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("-|-%s-|-%s", rol, sucursal);
    }
}
