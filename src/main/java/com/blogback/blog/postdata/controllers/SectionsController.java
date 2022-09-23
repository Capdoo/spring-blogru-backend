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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postdata/sections")
public class SectionsController {

    @Autowired
    PostDataService postDataService;

    @Autowired
    SectionService sectionService;

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


    //Read unique
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/read")
    public ResponseEntity<Object> readSection(@RequestParam long idPostData, @RequestParam int idSection){
        if(!postDataService.existsPostDataByIdPost(idPostData)){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }
        if(!sectionService.existsSectionByIdPostData(idPostData, idSection)){
            return new ResponseEntity<>(new MensajeDTO("Post Data Section does not exist"), HttpStatus.BAD_REQUEST);
        }

        SectionDTO sectionDTO = sectionService.readSection(idPostData, idSection);
        return new ResponseEntity<>(sectionDTO, HttpStatus.CREATED);

    }

    //Read all
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/readAll")
    public ResponseEntity<Object> readAllSections(@RequestParam long idPostData){
        if(!postDataService.existsPostDataByIdPost(idPostData)){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        List<SectionDTO> listSectionsDTO = sectionService.readAllSections(idPostData);

        return new ResponseEntity<>(listSectionsDTO, HttpStatus.CREATED);
    }
    //Update
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Object> updateSection(@RequestBody SectionDTO sectionDTO){
        if(!postDataService.existsPostDataByIdPost(sectionDTO.getIdPostData())){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        sectionService.updateSection(sectionDTO);

        return new ResponseEntity<>(new MensajeDTO("Section updated"), HttpStatus.CREATED);
    }

    //Delete

}
