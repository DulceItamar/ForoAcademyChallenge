package com.ForoAcademy.controllers;

import com.ForoAcademy.domain.academyMember.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/academy-members")
public class AcademyMemberController {
    @Autowired
    private AcademyMemberRepository repository;

    @PostMapping
    public ResponseEntity<DataResponseAcademyMember> signInAcademyMember(@RequestBody @Valid DataSignInAcademyMember dataSignInAcademyMember, UriComponentsBuilder uriComponentsBuilder){
        AcademyMember academyMember = new AcademyMember(dataSignInAcademyMember);
        repository.save(academyMember);

        DataResponseAcademyMember dataResponseAcademyMember = new DataResponseAcademyMember( academyMember.getId(), academyMember.getName(), academyMember.getEmail(), academyMember.getMemberCategory(),
                academyMember.getIsActive());

        var uri = uriComponentsBuilder.path("academy-members/{id}").buildAndExpand(academyMember.getId()).toUri();
        return ResponseEntity.created(uri).body(dataResponseAcademyMember);

    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<DataAcademyMemberList>> academyMemeberList(@PageableDefault(size = 5)Pageable pageable){

        return ResponseEntity.ok(repository.findAllByIsActiveTrue(pageable).map(DataAcademyMemberList::new));


    }



}
