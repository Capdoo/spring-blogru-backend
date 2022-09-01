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



}








