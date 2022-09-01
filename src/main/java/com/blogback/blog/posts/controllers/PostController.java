package com.blogback.blog.posts.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.posts.dto.ContentDTO;
import com.blogback.blog.posts.dto.PostCreateDTO;
import com.blogback.blog.posts.services.ContentService;
import com.blogback.blog.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    ContentService contentService;

    @Autowired
    PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Object> crearPost(@RequestBody PostCreateDTO postCreateDTO){

        //Guardar Metadata del Post
        postService.saveFirst(postCreateDTO);

        return new ResponseEntity<>(new MensajeDTO("Post Guardado Correctamente"), HttpStatus.CREATED);

    }

    @PostMapping("/setContent")
    public ResponseEntity<Object> saveContentPost(@RequestBody ContentDTO contentDTO){

        //1. Iniciar contenidos y comentarios
        long id_content = contentService.createPostContent(contentDTO.getId_post());
        long id_comments = contentService.createPostComments(contentDTO.getId_post());

        postService.setContent(contentDTO.getId_post(), id_content, id_comments);

        //3. Insertar contenido

        return new ResponseEntity<>(new MensajeDTO("Post Content Set"), HttpStatus.CREATED);


    }



}
