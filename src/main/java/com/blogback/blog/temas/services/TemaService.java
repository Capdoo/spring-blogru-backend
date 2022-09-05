package com.blogback.blog.temas.services;

import com.blogback.blog.temas.dto.TemaDTO;
import com.blogback.blog.temas.models.TemasModel;
import com.blogback.blog.temas.repositories.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemaService {

    @Autowired
    TemaRepository temaRepository;

    public void guardarTema(TemaDTO temaDTO){
        TemasModel temaModel = new TemasModel();
            temaModel.setNombreTema(temaDTO.getNombreTema());
            temaModel.setDescripcionTema(temaDTO.getDescripcionTema());
            temaModel.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        temaRepository.save(temaModel);;
    }

    public List<TemaDTO> getAllTemas(){
        List<TemaDTO> listaTemas = new ArrayList<TemaDTO>();

        List<TemasModel> listaCompleta = temaRepository.findAll();
        for(TemasModel p:listaCompleta){
            TemaDTO temaSend = new TemaDTO();
                temaSend.setIdTema(p.getIdTema());
                temaSend.setNombreTema(p.getNombreTema());
                temaSend.setDescripcionTema(p.getDescripcionTema());
            listaTemas.add(temaSend);
        }
        return listaTemas;
    }

    public boolean isExistsAllTemas(){
        List<TemasModel> temasModelOptional = temaRepository.findAll();
        if(temasModelOptional.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean isExistsByNombreTema(String nombreTema){
        Optional<TemasModel> temasModelOptional = temaRepository.findByNombreTema(nombreTema);

        if(temasModelOptional.isPresent()){
            return false;
        }
        return false;
    }

    public Optional<TemasModel> getById(int idTema){
        return temaRepository.findByIdTema(idTema);
    }


}
