package com.blogback.blog.temas.repositories;

import com.blogback.blog.temas.models.SubtemasModel;
import com.blogback.blog.temas.models.TemasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubtemaRepository extends JpaRepository<SubtemasModel, Integer> {

    public Optional<SubtemasModel> findByIdSubtema(int idSubtema);
    public Optional<SubtemasModel> findByNombreSubtema(String nombreTema);
}
