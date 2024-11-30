package com.cinetics.modelo;

import com.cinetics.utils.Utils;

public class Pelicula {
    private final String id;
    private String titulo;
    private String clasificacion;
    private String director;
    private int duracion;
    private String[] actores;
    private String sinopsis;
    private String sucursalID;
    private String horario;
    private int sala;
    private int disponibilidad;

    public Pelicula(String titulo, String clasificacion, String director, int duracion, String[] actores, String sinopsis, String sucursalID, String horario, int sala, int disponibilidad) {
        this.id = Utils.generarID();
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.director = director;
        this.duracion = duracion;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.horario = horario;
        this.sucursalID = sucursalID;
        this.sala = sala;
        this.disponibilidad = disponibilidad;
    }

    public Pelicula(String id, String titulo, String clasificacion, String director, int duracion, String[] actores, String sinopsis, String sucursalID, String horario, int sala, int disponibilidad) {
        this.id = id;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.director = director;
        this.duracion = duracion;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.horario = horario;
        this.sucursalID = sucursalID;
        this.sala = sala;
        this.disponibilidad = disponibilidad;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String[] getActores() {
        return actores;
    }

    public void setActores(String[] actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSucursalID() {
        return sucursalID;
    }

    public void setSucursalID(String sucursalID) {
        this.sucursalID = sucursalID;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String informacionCartelera(String nombreSucursal) {
        return String.format("| %-25s | %-8s | %-40s | %-8d | %-10s | %-15s | %-4d | %-5d |",
                titulo, clasificacion, director, duracion, nombreSucursal, horario, sala, disponibilidad);
    }

    @Override
    public String toString() {
        return String.format("%s-|-%s-|-%s-|-%s-|-%d-|-%s-|-%s-|-%s-|-%s-|-%d-|-%s",
                id, titulo, clasificacion, director, duracion, String.join(",", actores), sinopsis, horario, sucursalID, sala, disponibilidad
        );
    }
}
