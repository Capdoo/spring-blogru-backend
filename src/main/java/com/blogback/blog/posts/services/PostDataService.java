package com.blogback.blog.posts.services;

import com.blogback.blog.posts.data.PostData;
import com.blogback.blog.posts.dto.PostDataDTO;
import com.blogback.blog.posts.repositories.PostDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDataService {

    @Autowired
    PostDataRepository postDataRepository;


    public void save(PostDataDTO postDataDTO){
        PostData postData = new PostData();
            postData.setIdPostData(postDataDTO.getIdPost());
            postData.setTitle(postDataDTO.getTitle());
            postData.setComments(null);
            postData.setContent(postData.getContent());
        postDataRepository.save(postData);
    }

    public boolean existsPostDataByIdPost(long idPost){
        return postDataRepository.existsByIdPostData(idPost);
    }

}
