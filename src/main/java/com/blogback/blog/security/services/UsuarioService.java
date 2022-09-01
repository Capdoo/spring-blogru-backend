package com.blogback.blog.security.services;

import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.security.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
//Para implementar rollbacks y evitar incoherencia : Concurrencia
@Transactional
public class UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Optional<UsuarioModel> getById(long idUsuario){
        return usuarioRepository.findByIdUsuario(idUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
    }
}
