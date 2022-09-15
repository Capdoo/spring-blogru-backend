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

    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "idUsuario", nullable=false)
    private UsuarioModel usuario;

    //Mongo NonR DB

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tema_id", referencedColumnName = "idTema", foreignKey = @ForeignKey(name = "POST_FK_TEMA"))
    private TemasModel temasModel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subtema_id", referencedColumnName = "idSubtema", foreignKey = @ForeignKey(name = "POST_FK_SUBTEMA"))
    private SubtemasModel subtemasModel;

    public PostModel() {
    }

    public PostModel(UsuarioModel usuario, TemasModel temasModel, SubtemasModel subtemasModel) {
        this.usuario = usuario;
        this.temasModel = temasModel;
        this.subtemasModel = subtemasModel;
    }


    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public TemasModel getTemasModel() {
        return temasModel;
    }

    public void setTemasModel(TemasModel temasModel) {
        this.temasModel = temasModel;
    }

    public SubtemasModel getSubtemasModel() {
        return subtemasModel;
    }

    public void setSubtemasModel(SubtemasModel subtemasModel) {
        this.subtemasModel = subtemasModel;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

}








