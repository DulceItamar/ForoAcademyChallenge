package com.ForoAcademy.controllers;

import com.ForoAcademy.Service.PostService;
import com.ForoAcademy.domain.post.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Posts")
public class PostController {
    @Autowired
    private PostService service;

    @Autowired
    private PostRepository postRepository;

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

    @GetMapping
    public ResponseEntity<Page<DataPostList>> listPosts(@PageableDefault(size = 10, sort = "creationDate") Pageable pageable){
        return ResponseEntity.ok(postRepository.findAll(pageable).map(DataPostList::new));
    }

    @GetMapping("/{id}")
    @Transactional
    public  ResponseEntity showPostById(@PathVariable @Valid Long id){
       var response = service.showPostDetails(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updatePost(@PathVariable @Valid Long id, @RequestBody @Valid DataUpdatePost dataUpdatePost){
        var updatedPost = service.updatePost(id, dataUpdatePost);
        return ResponseEntity.ok(updatedPost);
    }


}
