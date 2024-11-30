package com.cinetics.modelo;

import com.cinetics.utils.Utils;

public class Ticket {
    private final String id;
    private String sucursal;
    private int sala;
    private String pelicula;
    private Boleto[] boletos;
    private String fechaCompra;

    public Ticket(String sucursal, int sala, String pelicula, Boleto[] boletos, String fechaCompra) {
        this.id = Utils.generarID();
        this.sucursal = sucursal;
        this.sala = sala;
        this.pelicula = pelicula;
        this.boletos = boletos;
        this.fechaCompra = fechaCompra;
    }
    public Ticket(String id, String sucursal, int sala, String pelicula, Boleto[] boletos, String fechaCompra) {
        this.id = id;
        this.sucursal = sucursal;
        this.sala = sala;
        this.pelicula = pelicula;
        this.boletos = boletos;
        this.fechaCompra = fechaCompra;
    }
}
