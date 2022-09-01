package com.blogback.blog.security.controllers;

import com.blogback.blog.dto.MensajeDTO;
import com.blogback.blog.security.dto.JwtDTO;
import com.blogback.blog.security.dto.LoginUsuarioDTO;
import com.blogback.blog.security.dto.NuevoUsuarioDTO;
import com.blogback.blog.security.enums.RolNombre;
import com.blogback.blog.security.jwt.JwtProvider;
import com.blogback.blog.security.models.RolModel;
import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.security.services.RolService;
import com.blogback.blog.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> nuevo(@RequestBody NuevoUsuarioDTO nuevoUsuarioDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new MensajeDTO("Campos mal colocados"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByNombreUsuario(nuevoUsuarioDTO.getNombreUsuario())) {
            return new ResponseEntity(new MensajeDTO("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);

        }
        if (usuarioService.existsByEmail(nuevoUsuarioDTO.getEmail())) {
            return new ResponseEntity(new MensajeDTO("El email ya existe"), HttpStatus.BAD_REQUEST);

        }

        UsuarioModel usuarioModel = new UsuarioModel(
                nuevoUsuarioDTO.getNombre(),
                nuevoUsuarioDTO.getNombreUsuario(),
                nuevoUsuarioDTO.getEmail(),
                passwordEncoder.encode(nuevoUsuarioDTO.getPassword())
        );

        Set<RolModel> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuarioDTO.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }

        usuarioModel.setRoles(roles);
        usuarioService.save(usuarioModel);

        return new ResponseEntity(new MensajeDTO("Usuario guardado"), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginUsuarioDTO loginUsuarioDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new MensajeDTO("Campos mal colocados"), HttpStatus.BAD_REQUEST);
        }

        if(!(usuarioService.existsByNombreUsuario(loginUsuarioDTO.getNombreUsuario()))) {
            return new ResponseEntity(new MensajeDTO("Campos mal colocados"), HttpStatus.BAD_REQUEST);
        }

        return Autenticacion(loginUsuarioDTO.getNombreUsuario(), loginUsuarioDTO.getPassword());

    }

    public ResponseEntity<Object> Autenticacion(String username, String password) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
            return new ResponseEntity(jwtDto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new MensajeDTO("Campos mal colocados"), HttpStatus.BAD_REQUEST);
        }

    }

}
