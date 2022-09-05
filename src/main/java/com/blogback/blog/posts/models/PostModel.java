package com.blogback.blog.posts.models;

import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.temas.models.SubtemasModel;
import com.blogback.blog.temas.models.TemasModel;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPost;

    //Metadata
    private int idTema;
    private int idSubtema;

    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "idUsuario", nullable=false)
    private UsuarioModel usuario;

    //Mongo NonR DB
    private long idContent;
    private long idComments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tema_id", referencedColumnName = "idTema", foreignKey = @ForeignKey(name = "POST_FK_TEMA"))
    private TemasModel temasModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subtema_id", referencedColumnName = "idSubtema", foreignKey = @ForeignKey(name = "POST_FK_SUBTEMA"))
    private SubtemasModel subtemasModel;

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

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
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








