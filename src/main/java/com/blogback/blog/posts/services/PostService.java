package com.blogback.blog.posts.services;

import com.blogback.blog.posts.dto.PostCreateDTO;
import com.blogback.blog.posts.models.PostModel;
import com.blogback.blog.posts.repositories.PostRepository;
import com.blogback.blog.security.models.UsuarioModel;
import com.blogback.blog.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioService usuarioService;

    public void saveFirst(PostCreateDTO postCreateDTO){

        Optional<UsuarioModel> usuarioCreador = usuarioService.getById(postCreateDTO.getUser_id());

        PostModel postModel = new PostModel(postCreateDTO.getTema_id(),
                                            postCreateDTO.getSubtema_id(),
                                            usuarioCreador.get());
        postRepository.save(postModel);

    }

    public void setContent(long idPost, long idContent, long idComments){
        PostModel postIndicado = postRepository.findById(idPost).get();
            postIndicado.setIdContent(idContent);
            postIndicado.setIdComments(idContent);
        postRepository.save(postIndicado);
    }

    public void updatePost(long id_content, long id_comment){

    }



}









