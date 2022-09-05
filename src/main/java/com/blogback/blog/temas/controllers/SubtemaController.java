package com.blogback.blog.temas.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.temas.dto.SubtemaDTO;
import com.blogback.blog.temas.services.SubtemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subtemas")
public class SubtemaController {

    @Autowired
    SubtemaService subtemaService;

    @PostMapping
    public ResponseEntity<Object> guardarSubtema(@RequestBody SubtemaDTO subtemaDTO){
        if(subtemaService.isExistsByNombreSubtema(subtemaDTO.getNombreSubtema())){
            return new ResponseEntity<>(new MensajeDTO("El subtema ya existe"), HttpStatus.BAD_REQUEST);
        }
        subtemaService.guardarSubtema(subtemaDTO);
        return new ResponseEntity<>(new MensajeDTO("Subtema creado correctamente"), HttpStatus.CREATED);

    }

}
