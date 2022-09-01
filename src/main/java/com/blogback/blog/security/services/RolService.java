package com.blogback.blog.security.services;

import com.blogback.blog.security.enums.RolNombre;
import com.blogback.blog.security.models.RolModel;
import com.blogback.blog.security.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {


    @Autowired
    RolRepository rolRepository;

    public Optional<RolModel> getByRolNombre (RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(RolModel rolModel) {
        rolRepository.save(rolModel);
    }
}
