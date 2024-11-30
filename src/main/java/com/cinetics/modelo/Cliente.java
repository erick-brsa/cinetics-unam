package com.cinetics.modelo;

public class Cliente extends Usuario {
    private int nivel;  // Nivel de lealtad
    private int puntos; // Puntos de lealtad

    public Cliente(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String email, String password) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email, password);
    }

    public Cliente(String id, String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String email, String password, int nivel, int puntos) {
        super(id, nombre, primerApellido, segundoApellido, direccion, telefono, email, password);
        this.nivel = nivel;
        this.puntos = puntos;
    }

    public Cliente(String id, String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String rfc, String direccionFiscal, String email, String password, int nivel, int puntos) {
        super(id, nombre, primerApellido, segundoApellido, direccion, telefono, rfc, direccionFiscal, email, password);
        this.nivel = nivel;
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("-|-%d-|-%d\n", nivel, puntos);
    }
}
