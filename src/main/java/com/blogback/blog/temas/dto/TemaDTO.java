package com.blogback.blog.temas.dto;

public class TemaDTO {

    private int idTema;
    private String nombreTema;
    private String descripcionTema;

    public TemaDTO() {
    }

    public TemaDTO(int idTema, String nombreTema, String descripcionTema) {
        this.idTema = idTema;
        this.nombreTema = nombreTema;
        this.descripcionTema = descripcionTema;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getDescripcionTema() {
        return descripcionTema;
    }

    public void setDescripcionTema(String descripcionTema) {
        this.descripcionTema = descripcionTema;
    }
}
