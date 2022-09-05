package com.blogback.blog.posts.services;

import com.blogback.blog.posts.dto.PostCreateDTO;
import com.blogback.blog.posts.models.PostModel;
import com.blogback.blog.posts.repositories.PostRepository;
import com.blogback.blog.security.models.RolModel;
import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.security.services.UsuarioService;
import com.blogback.blog.temas.models.SubtemasModel;
import com.blogback.blog.temas.models.TemasModel;
import com.blogback.blog.temas.services.SubtemaService;
import com.blogback.blog.temas.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TemaService temaService;

    @Autowired
    SubtemaService subtemaService;

    public void saveFirst(PostCreateDTO postCreateDTO){

        Optional<UsuarioModel> usuarioCreador = usuarioService.getById(postCreateDTO.getUser_id());
        Optional<TemasModel> temasModel = temaService.getById(postCreateDTO.getTema_id());
        Optional<SubtemasModel> subtemasModel = subtemaService.getById(postCreateDTO.getSubtema_id());


        PostModel postModel = new PostModel();
        postModel.setUsuario(usuarioCreador.get());
        postModel.setTemasModel(temasModel.get());
        postModel.setSubtemasModel(subtemasModel.get());

        System.out.println("Temas model nombre"+temasModel.get().getNombreTema());


        System.out.println("Sub temas model nombre"+subtemasModel.get().getNombreSubtema());
        System.out.println("Sub temas model nombre"+subtemasModel.get().getIdSubtema());
        System.out.println("Sub temas model nombre"+subtemasModel.get().getFechaCreacion());



        postRepository.save(postModel);

    }

    public void setContent(long idPost, long idContent, long idComments){
        PostModel postIndicado = postRepository.findById(idPost).get();
            postIndicado.setIdContent(idContent);
            postIndicado.setIdComments(idContent);
        postRepository.save(postIndicado);
    }

    public boolean isUserACreator(long id_usuario){
        UsuarioModel usuarioModel = usuarioService.getById(id_usuario).get();
        List<String> listaRoles = usuarioService.getRolesString(id_usuario);
        for (String p:listaRoles){
            if(p.equals("ROLE_CREATOR")){
                return true;
            }
        }

        return false;
    }



}









