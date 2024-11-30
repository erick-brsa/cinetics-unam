package com.cinetics.modelo;

import com.cinetics.utils.Utils;

public class Boleto {
    private final String id;
    private String tipo;
    private int costo;
    private String peliculaID;

    public Boleto(String tipo, int costo, String peliculaID) {
        this.id = Utils.generarID();
        this.tipo = tipo;
        this.costo = costo;
        this.peliculaID = peliculaID;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(String peliculaID) {
        this.peliculaID = peliculaID;
    }
}
