package com.ForoAcademy.controllers;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import com.ForoAcademy.domain.academyMember.AcademyMemberRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academy-members")
public class AcademyMemberController {
    private AcademyMemberRepository repository;

    @PostMapping
    public void registrarMedico(){
        System.out.println("Conexión exitosa a la base de datos");
    }
}
