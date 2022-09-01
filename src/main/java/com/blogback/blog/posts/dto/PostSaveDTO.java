package com.blogback.blog.posts.dto;

public class PostSaveDTO {

    private int user_id;
    private int tema_id;
    private long content_id;
    private long comments_id;

    public PostSaveDTO(int user_id, int tema_id) {
        this.user_id = user_id;
        this.tema_id = tema_id;
    }

    public PostSaveDTO(int user_id, int tema_id, long content_id, long comments_id) {
        this.user_id = user_id;
        this.tema_id = tema_id;
        this.content_id = content_id;
        this.comments_id = comments_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTema_id() {
        return tema_id;
    }

    public void setTema_id(int tema_id) {
        this.tema_id = tema_id;
    }

    public long getContent_id() {
        return content_id;
    }

    public void setContent_id(long content_id) {
        this.content_id = content_id;
    }

    public long getComments_id() {
        return comments_id;
    }

    public void setComments_id(long comments_id) {
        this.comments_id = comments_id;
    }
}
