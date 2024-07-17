package com.ForoAcademy.Service;

import com.ForoAcademy.domain.academyMember.AcademyMemberRepository;
import com.ForoAcademy.domain.academyMember.MemberCategory;
import com.ForoAcademy.domain.post.*;
import com.ForoAcademy.infra.errors.IntegrityValidation;
import com.ForoAcademy.validations.PostValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    AcademyMemberRepository academyMemberRepository;

    List<PostValidator> validators;
    public DataPostDetails createAPost(DataCreateAPost data){

        if (!academyMemberRepository.findIsActiveAcademyMemberByEmail(data.academyMemberEmail().toLowerCase()).isPresent()){
            throw new IntegrityValidation("El correo no se encuentra registrado.");

        }

        var academyMember = academyMemberRepository.findIsActiveAcademyMemberByEmail(data.academyMemberEmail()).get();

        var newPost = new Post(
                null,
                data.title(),
                data.message(),
                LocalDateTime.now(),
                academyMember,
                null
        );
        postRepository.save(newPost);
        return new DataPostDetails(newPost);

    }

    public String deletePost(DataDeletePost dataDeletePost){

       if (dataDeletePost.memberCategory() != MemberCategory.ADMIN ) {
           throw new IntegrityValidation("Categoría no autorizada para eliminar Post");
       }
       var post = postRepository.getReferenceById(dataDeletePost.idPost());
       var deletingReason = dataDeletePost.DeletingReason();
       return "Post eliminado. Motivo: " + deletingReason;
    }

    public DataPostDetails showPostDetails(@Valid Long id){
        if (!postRepository.existsById(id)){
            throw new IntegrityValidation("El post que busca no se ha encontrado");
        }
        return new DataPostDetails(postRepository.getReferenceById(id));
    }


    public Post updatePost(Long idPost, @Valid DataUpdatePost dataUpdatePost ){
        if (!postRepository.existsById(idPost)){
            throw  new IntegrityValidation("El Post que desea actualizar no ha sido encontrado");
        }

        if (!postRepository.findByIdAndAuthorId(idPost, dataUpdatePost.idAuthor()).isPresent()){
            throw new IntegrityValidation(("El autor no corresponde al Post que desea actualizar"));
        }
        Post updatePost = postRepository.getReferenceById(idPost);
        updatePost.updatePost(dataUpdatePost);

        return updatePost;
    }



}
