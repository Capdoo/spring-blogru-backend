package com.blogback.blog.postdata.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.postdata.dto.HeaderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postdata/headers")
public class HeardersController {


    public ResponseEntity<Object> createHeader(@RequestBody HeaderDTO headerDTO){
        return new ResponseEntity<>(new MensajeDTO("Header created"), HttpStatus.CREATED);
    }

}



