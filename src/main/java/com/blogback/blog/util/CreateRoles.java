package com.blogback.blog.util;

import com.example.demo.security.enums.RolNombre;
import com.example.demo.security.model.RolModel;
import com.example.demo.security.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CreateRoles implements CommandLineRunner {


    @Autowired
    RolService rolService;

    //@Override
    public void run(String... args) throws Exception {

        RolModel rolAdmin = new RolModel(RolNombre.ROLE_ADMIN);
        RolModel rolUser = new RolModel(RolNombre.ROLE_USER);

        rolService.save(rolAdmin);
        rolService.save(rolUser);

    }



}
