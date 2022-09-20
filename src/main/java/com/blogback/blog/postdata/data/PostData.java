package com.blogback.blog.postdata.data;

import com.blogback.blog.postdata.elements.SectionsElement;
import com.blogback.blog.posts.dto.CommentDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="posts")
public class PostData {


    private long idPostData;

    private String title;

    private List<CommentDTO> comments;

    private List<SectionsElement> sections;

    public PostData() {
    }

    public PostData(long idPostData, String title, List<CommentDTO> comments, List<SectionsElement> sections) {
        this.idPostData = idPostData;
        this.title = title;
        this.comments = comments;
        this.sections = sections;
    }

    public long getIdPostData() {
        return idPostData;
    }

    public void setIdPostData(long idPostData) {
        this.idPostData = idPostData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<SectionsElement> getSections() {
        return sections;
    }

    public void setSections(List<SectionsElement> sections) {
        this.sections = sections;
    }
}
