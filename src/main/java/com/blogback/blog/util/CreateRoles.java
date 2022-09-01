package com.blogback.blog.util;

import com.blogback.blog.security.enums.RolNombre;
import com.blogback.blog.security.models.RolModel;
import com.blogback.blog.security.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CreateRoles /*implements CommandLineRunner*/ {

    @Autowired
    RolService rolService;  

    //@Override
    public void run(String... args) throws Exception {

        RolModel rolSuperAdmin = new RolModel(RolNombre.ROLE_SUPERADMIN);
        RolModel rolAdmin = new RolModel(RolNombre.ROLE_ADMIN);
        RolModel rolCreator = new RolModel(RolNombre.ROLE_CREATOR);
        RolModel rolUser = new RolModel(RolNombre.ROLE_USER);

        rolService.save(rolSuperAdmin);
        rolService.save(rolAdmin);
        rolService.save(rolCreator);
        rolService.save(rolUser);

    }



}
