package com.blogback.blog.postdata.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.postdata.dto.HeaderDTO;
import com.blogback.blog.postdata.services.HeaderService;
import com.blogback.blog.postdata.services.PostDataService;
import com.blogback.blog.postdata.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postdata/headers")
public class HeadersController {

    @Autowired
    PostDataService postDataService;

    @Autowired
    SectionService sectionService;

    @Autowired
    HeaderService headerService;

    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> createHeader(@RequestBody HeaderDTO headerDTO){

        if(!postDataService.existsPostDataByIdPost(headerDTO.getIdPostData())){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        if(!sectionService.existsSectionByIdPostData(headerDTO.getIdPostData(), headerDTO.getIdSection())){
            return new ResponseEntity<>(new MensajeDTO("Post Data Section does not exist"), HttpStatus.BAD_REQUEST);
        }

        headerService.createHeader(headerDTO);

        return new ResponseEntity<>(new MensajeDTO("Header created"), HttpStatus.CREATED);
    }


    //read


    //update


    //delete

}



