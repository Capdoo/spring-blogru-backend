package com.blogback.blog.postdata.dto;

import com.blogback.blog.postdata.elements.SectionsElement;
import com.blogback.blog.posts.dto.CommentDTO;

import java.util.List;

public class PostDataContentDTO {

    private long idPost;

    private String title;

    private List<SectionsElement> listSections;

    private List<CommentDTO> listComments;

    public PostDataContentDTO() {
    }

    public PostDataContentDTO(long idPost, String title, List<SectionsElement> listSections, List<CommentDTO> listComments) {
        this.idPost = idPost;
        this.title = title;
        this.listSections = listSections;
        this.listComments = listComments;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SectionsElement> getListSections() {
        return listSections;
    }

    public void setListSections(List<SectionsElement> listSections) {
        this.listSections = listSections;
    }

    public List<CommentDTO> getListComments() {
        return listComments;
    }

    public void setListComments(List<CommentDTO> listComments) {
        this.listComments = listComments;
    }
}
