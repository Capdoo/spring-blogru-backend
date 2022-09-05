package com.blogback.blog.temas.models;

import com.blogback.blog.posts.models.PostModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;

@Entity
@Table(name="temas")
public class TemasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTema;

    //Contenido
    private String nombreTema;

    private String descripcionTema;

    private Timestamp fechaCreacion;

    @OneToOne(cascade =  CascadeType.ALL,mappedBy = "temasModel")
    private PostModel postModel;

    public TemasModel() {
    }

    public TemasModel(String nombreTema, String descripcionTema, Timestamp fechaCreacion) {
        this.nombreTema = nombreTema;
        this.descripcionTema = descripcionTema;
        this.fechaCreacion = fechaCreacion;
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

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public PostModel getPostModel() {
        return postModel;
    }

    public void setPostModel(PostModel postModel) {
        this.postModel = postModel;
    }
}
