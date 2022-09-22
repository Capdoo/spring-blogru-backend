package com.blogback.blog.postdata.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.postdata.dto.SectionDTO;
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
@RequestMapping("/postdata/sections")
public class SectionsController {

    @Autowired
    PostDataService postDataService;

    @Autowired
    SectionService sectionService;

    @Autowired
    HeaderService headerService;


    //Create
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> createSection(@RequestBody SectionDTO sectionDTO){
        if(!postDataService.existsPostDataByIdPost(sectionDTO.getIdPostData())){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        sectionService.createSection(sectionDTO);

        return new ResponseEntity<>(new MensajeDTO("Section created"), HttpStatus.CREATED);

    }


    //Read


    //Update


    //Delete

}
