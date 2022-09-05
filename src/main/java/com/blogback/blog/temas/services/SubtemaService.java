package com.blogback.blog.temas.services;

import com.blogback.blog.temas.dto.SubtemaDTO;
import com.blogback.blog.temas.dto.TemaDTO;
import com.blogback.blog.temas.models.SubtemasModel;
import com.blogback.blog.temas.models.TemasModel;
import com.blogback.blog.temas.repositories.SubtemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubtemaService {

    @Autowired
    SubtemaRepository subtemaRepository;

    public void guardarSubtema(SubtemaDTO subtemaDTO){
        SubtemasModel subtema = new SubtemasModel();
            subtema.setNombreSubtema(subtemaDTO.getNombreSubtema());
            subtema.setDescripcionSubtema(subtemaDTO.getDescripcionSubtema());
            subtema.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        subtemaRepository.save(subtema);
    }

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

    public boolean isExistsByNombreSubtema(String nombreSubtema){
        int idSubtema = subtemaRepository.findByNombreSubtema(nombreSubtema).get().getIdSubtema();
        return subtemaRepository.existsById(idSubtema);
    }

}
