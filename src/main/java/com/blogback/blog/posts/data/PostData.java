package com.blogback.blog.posts.data;

import com.blogback.blog.posts.contents.PostDataContentDTO;
import com.blogback.blog.posts.contents.SectionsDTO;
import com.blogback.blog.posts.dto.CommentDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Document(collection="posts")
public class PostData {

    private long idPostData;

    private String title;

    private List<CommentDTO> comments;

    private List<SectionsDTO> sections;

    public PostData() {
    }

    public PostData(long idPostData, String title, List<CommentDTO> comments, List<SectionsDTO> sections) {
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

    public List<SectionsDTO> getSections() {
        return sections;
    }

    public void setSections(List<SectionsDTO> sections) {
        this.sections = sections;
    }
}
