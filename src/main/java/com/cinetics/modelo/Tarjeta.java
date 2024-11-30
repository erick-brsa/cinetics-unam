package com.cinetics.modelo;

public class Tarjeta {
    private String titular;
    private String numero;
    private String fechaVigencia;
    private String codigoVerificacion;
    private String tipo;
    private String clienteID;

    public Tarjeta(String titular, String numero, String fechaVigencia, String codigoVerificacion, String tipo, String clienteID) {
        this.titular = titular;
        this.numero = numero;
        this.fechaVigencia = fechaVigencia;
        this.codigoVerificacion = codigoVerificacion;
        this.tipo = tipo;
        this.clienteID = clienteID;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }
}
