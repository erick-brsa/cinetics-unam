package com.cinetics.modelo;

public class Producto {
    private String nombre;
    private String codigo;
    private int precio;
    private String categoria;
    private int stockCU;
    private int stockUniversidad;
    private int stockDelta;
    private int stockXochimilco;

    public Producto(String nombre, String codigo, int precio, String categoria, int stockCU, int stockUniversidad, int stockDelta, int stockXochimilco) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stockCU = stockCU;
        this.stockUniversidad = stockUniversidad;
        this.stockDelta = stockDelta;
        this.stockXochimilco = stockXochimilco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStockCU() {
        return stockCU;
    }

    public void setStockCU(int stockCU) {
        this.stockCU = stockCU;
    }

    public int getStockUniversidad() {
        return stockUniversidad;
    }

    public void setStockUniversidad(int stockUniversidad) {
        this.stockUniversidad = stockUniversidad;
    }

    public int getStockDelta() {
        return stockDelta;
    }

    public void setStockDelta(int stockDelta) {
        this.stockDelta = stockDelta;
    }

    public int getStockXochimilco() {
        return stockXochimilco;
    }

    public void setStockXochimilco(int stockXochimilco) {
        this.stockXochimilco = stockXochimilco;
    }

    public String informacionProducto() {
        return String.format("| %-20s | %-15s | %-8d | %-15s | %-10d | %-15d | %-10d | %-15d |",
                nombre, codigo, precio, categoria, stockCU, stockUniversidad, stockDelta, stockXochimilco);
    }
}
