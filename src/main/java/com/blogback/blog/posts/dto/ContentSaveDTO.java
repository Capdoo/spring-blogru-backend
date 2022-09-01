package com.blogback.blog.posts.dto;

public class ContentSaveDTO {

    private long id;
    private long id_post;
    private long id_usuario;

    public ContentSaveDTO(long id, long id_post, long id_usuario) {
        this.id = id;
        this.id_post = id_post;
        this.id_usuario = id_usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
