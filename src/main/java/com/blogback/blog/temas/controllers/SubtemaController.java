package com.blogback.blog.temas.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.temas.dto.SubtemaDTO;
import com.blogback.blog.temas.services.SubtemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtemas")
public class SubtemaController {

    @Autowired
    SubtemaService subtemaService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> crearSubtema(@RequestBody SubtemaDTO subtemaDTO){
        if(subtemaService.isExistsByNombreSubtema(subtemaDTO.getNombreSubtema())){
            return new ResponseEntity<>(new MensajeDTO("El subtema ya existe"), HttpStatus.BAD_REQUEST);
        }
        subtemaService.guardarSubtema(subtemaDTO);
        return new ResponseEntity<>(new MensajeDTO("Subtema creado correctamente"), HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/obtener")
    public ResponseEntity<Object> obtenerSubtemas(){
        if(!subtemaService.isExistsAllSubtemas()){
            return new ResponseEntity<Object>(new MensajeDTO("No existen subtemas"),HttpStatus.BAD_REQUEST);
        }
        List<SubtemaDTO> subtemaDTOList = subtemaService.getAllSubtemas();
        return new ResponseEntity<Object>(subtemaDTOList,HttpStatus.OK);
    }

}
