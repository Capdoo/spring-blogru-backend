package com.blogback.blog.posts.repositories;

import com.blogback.blog.posts.data.PostData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostDataRepository extends MongoRepository<PostData, Long> {

    public Optional<PostData> findPostDataByIdPostData(long idPostData);

    public void deleteByIdPostData(long idPostData);

    public boolean existsByIdPostData(long idPostData);

}
