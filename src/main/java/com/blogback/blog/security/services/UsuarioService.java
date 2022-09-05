package com.blogback.blog.security.services;

import com.blogback.blog.security.models.RolModel;
import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.security.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public List<String> getRolesString(long idUsuario){
        List<String> listaRoles = new ArrayList<String>();

        Set<RolModel> rolesModel = usuarioRepository.findByIdUsuario(idUsuario).get().getRoles();
        for(RolModel p:rolesModel){
            String rol = String.valueOf(p.getRolNombre());
            listaRoles.add(rol);
        }
        return listaRoles;
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
