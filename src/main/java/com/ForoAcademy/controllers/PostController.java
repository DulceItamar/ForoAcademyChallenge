package com.ForoAcademy.controllers;

import com.ForoAcademy.Service.PostService;
import com.ForoAcademy.domain.post.DataCreateAPost;
import com.ForoAcademy.domain.post.DataDeletePost;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Posts")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping
    @Transactional
    public ResponseEntity createAPost(@RequestBody @Valid DataCreateAPost data){
        var response = service.createAPost(data);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteAPost(@RequestBody @Valid DataDeletePost dataDeletePost){
        var response = service.deletePost(dataDeletePost);
        return  ResponseEntity.ok(response);
    }




}
