package com.blogback.blog.posts.services;

import com.blogback.blog.posts.contents.PostDataContentDTO;
import com.blogback.blog.posts.data.PostData;
import com.blogback.blog.posts.dto.CommentDTO;
import com.blogback.blog.posts.repositories.PostDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PostDataService {

    @Autowired
    PostDataRepository postDataRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public void save(PostDataContentDTO postDataContentDTO){
        PostData postData = new PostData();
            postData.setIdPostData(postDataContentDTO.getIdPost());
            postData.setTitle(postDataContentDTO.getTitle());
            postData.setComments(postDataContentDTO.getListComments());
            postData.setSections(postDataContentDTO.getListSections());
        postDataRepository.save(postData);
    }

    public void setNewComment(CommentDTO commentDTO){

        PostData postData = postDataRepository.findPostDataByIdPostData(commentDTO.getIdPost()).get();

        List<CommentDTO> listComments;
        if(postData.getComments() == null){
            listComments = new ArrayList<CommentDTO>();
        }else{
            listComments = postData.getComments();
        }
        listComments.add(commentDTO);

        Query query = new Query();
        query.addCriteria(Criteria.where("idPostData").is(commentDTO.getIdPost()));

        Update updateQuery = new Update();
            updateQuery.set("comments",listComments);
            mongoTemplate.updateFirst(query,updateQuery,PostData.class);

            //mongoTemplate.updateMulti(query,updateQuery,PostData.class);
            //mongoTemplate.upsert(query,updateQuery,PostData.class);

    }

    public boolean existsPostDataByIdPost(long idPost){
        return postDataRepository.existsByIdPostData(idPost);
    }

}
