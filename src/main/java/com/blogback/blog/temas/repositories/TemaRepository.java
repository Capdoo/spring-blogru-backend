package com.blogback.blog.temas.repositories;

import com.blogback.blog.temas.models.TemasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemaRepository extends JpaRepository<TemasModel,Integer> {


    public Optional<TemasModel> findByIdTema(int idTema);
    public Optional<TemasModel> findByNombreTema(String nombreTema);
    public List<TemasModel> findAll();

}
