package com.blogback.blog.posts.dto;

public class PostCreateDTO {

    private long user_id;
    private int tema_id;
    private int subtema_id;

    public PostCreateDTO(int user_id, int tema_id) {
        this.user_id = user_id;
        this.tema_id = tema_id;
    }

    public PostCreateDTO(int user_id, int tema_id, int subtema_id, long content_id, long comments_id) {
        this.user_id = user_id;
        this.tema_id = tema_id;
        this.subtema_id = subtema_id;
    }

    public long getUser_id() {
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

    public int getSubtema_id() {
        return subtema_id;
    }

    public void setSubtema_id(int subtema_id) {
        this.subtema_id = subtema_id;
    }

}
