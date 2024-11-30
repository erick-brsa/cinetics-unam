package com.cinetics.modelo;

public class Sala {
    private String sucursalID;
    private int numero;
    private int capacidad;

    public Sala(String sucursalID, int numero, int capacidad) {
        this.sucursalID = sucursalID;
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public String getSucursalID() {
        return sucursalID;
    }

    public void setSucursalID(String sucursalID) {
        this.sucursalID = sucursalID;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
