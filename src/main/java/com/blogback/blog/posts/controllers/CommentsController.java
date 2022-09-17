package com.blogback.blog.posts.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.posts.dto.CommentDTO;
import com.blogback.blog.posts.services.PostDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    PostDataService postDataService;

    //Analyze role to comment ... thinkin'
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/set")
    public ResponseEntity<Object> setComment(@RequestBody CommentDTO commentDTO){
        if(!postDataService.existsPostDataByIdPost(commentDTO.getIdPost())){
            return new ResponseEntity<>(new MensajeDTO("Post doest not exist"), HttpStatus.BAD_REQUEST);
        }
        postDataService.setNewComment(commentDTO);
        return new ResponseEntity<>(new MensajeDTO("Comment sent"), HttpStatus.ACCEPTED);
    }
}
