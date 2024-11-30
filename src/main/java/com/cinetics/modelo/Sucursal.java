package com.cinetics.modelo;

import java.util.Arrays;

public class Sucursal {
    private String id;
    private String nombre;
    private Sala[] salas;

    public Sucursal(String id, String nombre, Sala[] salas) {
        this.id = id;
        this.nombre = nombre;
        this.salas = salas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return String.format("%s-|-%s-|-%s", id, nombre, Arrays.toString(salas));
    }
}
