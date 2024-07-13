package com.ForoAcademy.controllers;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import com.ForoAcademy.domain.academyMember.AcademyMemberRepository;
import com.ForoAcademy.domain.academyMember.DataResponseAcademyMember;
import com.ForoAcademy.domain.academyMember.DataSignInAcademyMember;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    
}
