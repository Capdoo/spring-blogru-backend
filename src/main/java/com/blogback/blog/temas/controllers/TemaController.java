package com.blogback.blog.temas.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.temas.dto.TemaDTO;
import com.blogback.blog.temas.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    TemaService temaService;

    @PostMapping
    public ResponseEntity<Object> ingresarTema(@RequestBody TemaDTO temaDTO){

        if(temaService.isExistsByNombreTema(temaDTO.getNombreTema())){
            return new ResponseEntity<Object>(new MensajeDTO("El tema ya existe"), HttpStatus.BAD_REQUEST);
        }

        temaService.guardarTema(temaDTO);

        return new ResponseEntity<>(new MensajeDTO("Tema creado correctamente"), HttpStatus.CREATED);
    }

}
