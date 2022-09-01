package com.blogback.blog.posts.repositories;

import com.blogback.blog.posts.models.PostModel;

public interface ContentRepository {


    public void savePostContent(PostModel postModel);
    public void savePostComments(PostModel postModel);





}
