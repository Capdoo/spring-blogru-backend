package com.blogback.blog.posts.services;

import com.blogback.blog.posts.models.PostModel;
import com.blogback.blog.posts.repositories.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentService implements ContentRepository {

    @Override
    public long createPostContent(Long idPost) {

        return 2;
    }

    @Override
    public long createPostComments(Long idPost) {

        return 4;
    }




}
