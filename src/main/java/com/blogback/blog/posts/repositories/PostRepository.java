package com.blogback.blog.posts.repositories;

import com.blogback.blog.posts.models.PostModel;
import com.blogback.blog.security.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostModel,Long> {

    Optional<PostModel> findById(Long idPost);
    Optional<PostModel> findByUsuario(UsuarioModel usuarioModel);

}
