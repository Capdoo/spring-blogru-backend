package com.blogback.blog.postdata.dto;

public class SingleDTO {

    private long idPost;

    public SingleDTO(long idPost) {
        this.idPost = idPost;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }
}
