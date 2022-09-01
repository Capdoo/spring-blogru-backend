package com.blogback.blog.posts.models;

import com.blogback.blog.security.models.UsuarioModel;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Metadata
    private int idTema;
    private int idSubtema;

    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "id", nullable=false)
    private UsuarioModel usuario;

    //Mongo NonR DB
    private long idContent;
    private long idComments;

    public PostModel() {
    }

    public PostModel(int idTema, int idSubtema, UsuarioModel usuario) {
        this.idTema = idTema;
        this.idSubtema = idSubtema;
        this.usuario = usuario;
    }

    public PostModel(int idTema, int idSubtema, UsuarioModel usuario, long idContent, long idComments) {

        this.idTema = idTema;
        this.idSubtema = idSubtema;
        this.usuario = usuario;
        this.idContent = idContent;
        this.idComments = idComments;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdSubtema() {
        return idSubtema;
    }

    public void setIdSubtema(int idSubtema) {
        this.idSubtema = idSubtema;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public long getIdContent() {
        return idContent;
    }

    public void setIdContent(long idContent) {
        this.idContent = idContent;
    }

    public long getIdComments() {
        return idComments;
    }

    public void setIdComments(long idComments) {
        this.idComments = idComments;
    }
}








