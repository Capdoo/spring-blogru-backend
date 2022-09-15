package com.blogback.blog.posts.dto;

public class CommentDTO {

    private long idPost;
    private long idComentador;
    private String comment;

    public CommentDTO() {
    }

    public CommentDTO(long idPost, long idComentador, String comment) {
        this.idPost = idPost;
        this.idComentador = idComentador;
        this.comment = comment;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public long getIdComentador() {
        return idComentador;
    }

    public void setIdComentador(long idComentador) {
        this.idComentador = idComentador;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
