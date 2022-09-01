package com.blogback.blog.posts.controllers;

import com.blogback.blog.posts.dto.PostSaveDTO;
import com.blogback.blog.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    public ResponseEntity<Object> crearPost(@RequestBody PostSaveDTO){

        //Guardar Metadata del Post

        //Enviar secciones de contenido y comentarios a Mongo

        //Actualizar Post


    }


}
