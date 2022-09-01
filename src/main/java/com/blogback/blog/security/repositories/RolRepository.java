package com.blogback.blog.security.repositories;

import com.blogback.blog.security.enums.RolNombre;
import com.blogback.blog.security.models.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolModel, Integer> {


    Optional<RolModel> findByRolNombre(RolNombre rolNombre);

}
