package com.blogback.blog.postdata.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.postdata.data.PostData;
import com.blogback.blog.postdata.dto.PostDataContentDTO;
import com.blogback.blog.postdata.dto.SingleDTO;
import com.blogback.blog.postdata.services.PostDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postdata")
public class PostDataController {

    @Autowired
    PostDataService postDataService;

    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> createContentPost(@RequestBody PostDataContentDTO postDataContentDTO){

        //1. If it does exist
        if(postDataService.existsPostDataByIdPost(postDataContentDTO.getIdPost())){
            return new ResponseEntity<>(new MensajeDTO("PostData already exists"), HttpStatus.BAD_REQUEST);
        }

        //Create new PostData:MongoDB
        postDataService.save(postDataContentDTO);

        return new ResponseEntity<>(new MensajeDTO("Post Data Content Set"), HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/read")
    public ResponseEntity<Object> readContentPost(@RequestParam long idPost){

        if(!postDataService.existsPostDataByIdPost(idPost)){
            return new ResponseEntity<>(new MensajeDTO("PostData does not exist"), HttpStatus.BAD_REQUEST);
        }
        PostDataContentDTO postData = postDataService.getPostDataById(idPost);
        return new ResponseEntity<>(postData, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteContentPost(@RequestParam long idPost){

        if(!postDataService.existsPostDataByIdPost(idPost)){
            return new ResponseEntity<>(new MensajeDTO("PostData does not exist"), HttpStatus.BAD_REQUEST);
        }
        postDataService.deletePostDataById(idPost);
        return new ResponseEntity<>(new MensajeDTO("PostData deleted"), HttpStatus.ACCEPTED);
    }

    //Update By Element

}
