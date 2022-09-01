package com.blogback.blog.posts.services;

import com.blogback.blog.posts.models.PostModel;
import com.blogback.blog.posts.repositories.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentService implements ContentRepository {

    @Override
    public void savePostContent(PostModel postModel) {

    }

    @Override
    public void savePostComments(PostModel postModel) {

    }

}
