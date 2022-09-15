package com.blogback.blog.posts.controllers;

import com.blogback.blog.posts.services.PostDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

    @Autowired
    PostDataService postDataService;



}
