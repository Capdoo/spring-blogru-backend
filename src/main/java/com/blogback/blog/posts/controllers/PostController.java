package com.blogback.blog.posts.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.posts.dto.ContentDTO;
import com.blogback.blog.posts.dto.PostCreateDTO;
import com.blogback.blog.posts.services.CommentsService;
import com.blogback.blog.posts.services.ContentService;
import com.blogback.blog.posts.services.PostService;
import com.blogback.blog.security.services.UsuarioService;
import com.blogback.blog.temas.services.SubtemaService;
import com.blogback.blog.temas.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    CommentsService commentsService;

    @Autowired
    PostService postService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TemaService temaService;

    @Autowired
    SubtemaService subtemaService;

    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> crearPost(@RequestBody PostCreateDTO postCreateDTO){

        //existe?
        if(!usuarioService.getById(postCreateDTO.getUser_id()).isPresent()){
            return new ResponseEntity<>(new MensajeDTO("Usuario no existe"), HttpStatus.BAD_REQUEST);
        }
        //debe ser creator

        if(!postService.isUserACreator(postCreateDTO.getUser_id())){
            return new ResponseEntity<>(new MensajeDTO("Usuario no es un creador"), HttpStatus.BAD_REQUEST);
        }

        if(!temaService.getById(postCreateDTO.getTema_id()).isPresent()){
            return new ResponseEntity<>(new MensajeDTO("El tema no existe"), HttpStatus.BAD_REQUEST);
        }

        if(!subtemaService.getById(postCreateDTO.getSubtema_id()).isPresent()){
            return new ResponseEntity<>(new MensajeDTO("El subtema no existe"), HttpStatus.BAD_REQUEST);
        }

        //Guardar Metadata del Post
        postService.saveFirst(postCreateDTO);

        return new ResponseEntity<>(new MensajeDTO("Post Guardado Correctamente"), HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/setContent")
    public ResponseEntity<Object> saveContentPost(@RequestBody ContentDTO contentDTO){

        //1. Si no existe
        if(!contentService.existsByIdPost(contentDTO.getId_post())){
            //1. Iniciar contenidos y comentarios
            long id_content = contentService.createPostContent(contentDTO.getId_post());
            long id_comments = contentService.createPostContent(contentDTO.getId_post());

            postService.setContent(contentDTO.getId_post(), id_content, id_comments);
        }

        //3. Insertar contenido
        contentService.savePostContent(contentDTO.getContenido());
        commentsService.savePostContent(contentDTO.getContenido());

        return new ResponseEntity<>(new MensajeDTO("Post Content Set"), HttpStatus.CREATED);

    }



}
