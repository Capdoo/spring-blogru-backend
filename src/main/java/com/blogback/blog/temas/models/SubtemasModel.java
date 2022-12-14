package com.blogback.blog.temas.models;

import com.blogback.blog.posts.models.PostModel;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="subtemas")
public class SubtemasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubtema;

    //Contenido
    private String nombreSubtema;

    private String descripcionSubtema;

    private Timestamp fechaCreacion;

    @OneToOne(cascade =  CascadeType.ALL,mappedBy = "subtemasModel")
    private PostModel postModel;

    public SubtemasModel() {
    }

    public SubtemasModel(String nombreSubtema, String descripcionSubtema, Timestamp fechaCreacion) {
        this.nombreSubtema = nombreSubtema;
        this.descripcionSubtema = descripcionSubtema;
        this.fechaCreacion = fechaCreacion;
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
