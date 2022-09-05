package com.blogback.blog.temas.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.temas.dto.TemaDTO;
import com.blogback.blog.temas.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    TemaService temaService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> crearTema(@RequestBody TemaDTO temaDTO){

        if(temaService.isExistsByNombreTema(temaDTO.getNombreTema())){
            return new ResponseEntity<Object>(new MensajeDTO("El tema ya existe"), HttpStatus.BAD_REQUEST);
        }

        temaService.guardarTema(temaDTO);

        return new ResponseEntity<>(new MensajeDTO("Tema creado correctamente"), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/obtener")
    public ResponseEntity<Object> obtenerTemas(){

        if(!temaService.isExistsAllTemas()){
            return new ResponseEntity<Object>(new MensajeDTO("No existen temas"),HttpStatus.BAD_REQUEST);
        }

        List<TemaDTO> listaTemas = temaService.getAllTemas();
        return new ResponseEntity<Object>(listaTemas,HttpStatus.OK);
    }

}
