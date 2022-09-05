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
import java.util.Optional;

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

    public boolean isExistsAllSubtemas(){
        List<SubtemasModel> subtemasModelList = subtemaRepository.findAll();
        if(subtemasModelList.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean isExistsByNombreSubtema(String nombreSubtema){
        Optional<SubtemasModel> subTemaModelOptional = subtemaRepository.findByNombreSubtema(nombreSubtema);

        if(subTemaModelOptional.isPresent()){
            return false;
        }
        return false;

    }

    public Optional<SubtemasModel> getById(int idSubtema){
        return subtemaRepository.findById(idSubtema);
    }

}
