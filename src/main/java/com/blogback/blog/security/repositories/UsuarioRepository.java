package com.blogback.blog.security.repositories;

import com.blogback.blog.security.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {


    Optional<UsuarioModel> findByNombreUsuario(String nombreUsuario);

    Optional<UsuarioModel> findByIdUsuario(long idUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);

}
