package com.blogback.blog.postdata.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.postdata.dto.HeaderDTO;
import com.blogback.blog.postdata.elements.HeadersElement;
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


    //Read list headers by section
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/read")
    public ResponseEntity<Object> readAllHeaders(@RequestParam long idPostData, @RequestParam int idSection){

        if(!postDataService.existsPostDataByIdPost(idPostData)){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        if(!sectionService.existsSectionByIdPostData(idPostData, idSection)){
            return new ResponseEntity<>(new MensajeDTO("Post Data Section does not exist"), HttpStatus.BAD_REQUEST);
        }

        List<HeadersElement> headerDTOList = headerService.readListHeaders(idPostData, idSection);

        return new ResponseEntity<>(headerDTOList, HttpStatus.CREATED);
    }

    //update
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Object> updateHeader(@RequestBody HeaderDTO headerDTO){

        if(!postDataService.existsPostDataByIdPost(headerDTO.getIdPostData())){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        if(!sectionService.existsSectionByIdPostData(headerDTO.getIdPostData(), headerDTO.getIdSection())){
            return new ResponseEntity<>(new MensajeDTO("Post Data Section does not exist"), HttpStatus.BAD_REQUEST);
        }

        if(!headerService.existsHeaderByIdPostDataAndIdSection(headerDTO.getIdPostData(), headerDTO.getIdSection(), headerDTO.getIdHeader())){
            return new ResponseEntity<>(new MensajeDTO("Header does not exist"), HttpStatus.BAD_REQUEST);
        }

        headerService.updateHeader(headerDTO);

        return new ResponseEntity<>(new MensajeDTO("Header updated"), HttpStatus.CREATED);
    }


    //delete
    @PreAuthorize("hasRole('ROLE_CREATOR') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteHeader(@RequestParam long idPostData, @RequestParam int idSection, @RequestParam int idHeader){

        if(!postDataService.existsPostDataByIdPost(idPostData)){
            return new ResponseEntity<>(new MensajeDTO("Post Data does not exist"), HttpStatus.BAD_REQUEST);
        }

        if(!sectionService.existsSectionByIdPostData(idPostData, idSection)){
            return new ResponseEntity<>(new MensajeDTO("Post Data Section does not exist"), HttpStatus.BAD_REQUEST);
        }

        if(!headerService.existsHeaderByIdPostDataAndIdSection(idPostData, idSection, idHeader)){
            return new ResponseEntity<>(new MensajeDTO("Header does not exist"), HttpStatus.BAD_REQUEST);
        }

        headerService.deleteHeader(idPostData, idSection, idHeader);

        return new ResponseEntity<>(new MensajeDTO("Header deleted"), HttpStatus.CREATED);
    }

}



