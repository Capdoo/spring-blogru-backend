package com.blogback.blog.security.services;

import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.security.models.UsuarioPrincipalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UsuarioModel usuarioModel = usuarioService.getByNombreUsuario(username).get();

        return UsuarioPrincipalModel.build(usuarioModel);
    }
}
