package com.blogback.blog.posts.controllers;

import com.blogback.blog.posts.services.PostDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postdata")
public class PostDataController {


    @Autowired
    PostDataService postDataService;

    /*
    public ResponseEntity<Object> setPostDataContent(@RequestBody SectionsDTO sectionsDTO){

    }
    */
}







