package com.blogback.blog.temas.services;

import com.blogback.blog.temas.dto.SubtemaDTO;
import com.blogback.blog.temas.models.SubtemasModel;
import com.blogback.blog.temas.repositories.SubtemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubtemaService {

    @Autowired
    SubtemaRepository subtemaRepository;

    public List<SubtemaDTO> getAllSubtemas(){
        List<SubtemaDTO> listaSubtemas = new ArrayList<>();
        List<SubtemasModel> listaCompleta = subtemaRepository.findAll();

        for(SubtemasModel p:listaCompleta){
            SubtemaDTO subtemaDTO = new SubtemaDTO();
                subtemaDTO.setIdSubtema(p.getIdSubtema());
                subtemaDTO.setNombreSubtema(p.getNombreSubtema());
                subtemaDTO.setDescripcionSubtema(p.getDescripcionSubtema());
            listaSubtemas.add(subtemaDTO);
        }
        return listaSubtemas;
    }

}
