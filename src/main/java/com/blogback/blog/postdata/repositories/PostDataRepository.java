package com.blogback.blog.postdata.repositories;

import com.blogback.blog.postdata.data.PostData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostDataRepository extends MongoRepository<PostData, Long> {
    public Optional<PostData> findPostDataByIdPostData(long idPostData);

    public void deleteByIdPostData(long idPostData);

    public boolean existsByIdPostData(long idPostData);

}
