package com.blogback.blog.posts.repositories;

import com.blogback.blog.posts.models.PostModel;

public interface ContentRepository {

    public long createPostContent(Long idContent);

    public void savePostContent(Object postContent);

    public boolean existsByIdPost(long idPost);
}
