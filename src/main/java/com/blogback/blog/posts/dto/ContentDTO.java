package com.blogback.blog.posts.dto;

public class ContentDTO {

    private long id_post;

    private Object contenido;

    public ContentDTO() {
    }

    public ContentDTO(long id_post, Object contenido) {
        this.id_post = id_post;
        this.contenido = contenido;
    }

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
}
