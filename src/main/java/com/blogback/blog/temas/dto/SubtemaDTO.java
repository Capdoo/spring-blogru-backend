package com.blogback.blog.temas.dto;

public class SubtemaDTO {

    private int idSubtema;
    private String nombreSubtema;
    private String descripcionSubtema;

    public SubtemaDTO() {
    }

    public SubtemaDTO(int idSubtema, String nombreSubtema, String descripcionSubtema) {
        this.idSubtema = idSubtema;
        this.nombreSubtema = nombreSubtema;
        this.descripcionSubtema = descripcionSubtema;
    }

    public int getIdSubtema() {
        return idSubtema;
    }

    public void setIdSubtema(int idSubtema) {
        this.idSubtema = idSubtema;
    }

    public String getNombreSubtema() {
        return nombreSubtema;
    }

    public void setNombreSubtema(String nombreSubtema) {
        this.nombreSubtema = nombreSubtema;
    }

    public String getDescripcionSubtema() {
        return descripcionSubtema;
    }

    public void setDescripcionSubtema(String descripcionSubtema) {
        this.descripcionSubtema = descripcionSubtema;
    }
}
