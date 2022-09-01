package com.blogback.blog.posts.repositories;

import com.blogback.blog.posts.models.PostModel;

public interface ContentRepository {


    public long createPostContent(Long idPost);
    public long createPostComments(Long idPost);






}
