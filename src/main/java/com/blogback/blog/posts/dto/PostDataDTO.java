package com.blogback.blog.posts.dto;


public class PostDataDTO {

    private long idPost;
    private String title;
    private Object content;

    public PostDataDTO() {
    }

    public PostDataDTO(long idPost, String title, Object content) {
        this.idPost = idPost;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }
}
