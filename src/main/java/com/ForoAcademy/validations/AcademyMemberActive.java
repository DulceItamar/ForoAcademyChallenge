package com.ForoAcademy.validations;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import com.ForoAcademy.domain.academyMember.AcademyMemberRepository;
import com.ForoAcademy.domain.post.DataCreateAPost;

import com.ForoAcademy.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ValueRange;

@Component
public class AcademyMemberActive implements PostValidator{
    @Autowired
    private AcademyMemberRepository repository;


    @Override
    public void validation(DataCreateAPost data) {

        if (data.academyMemberEmail() == null ) {
            return;
        }

        var academyMemberActive = repository.findIsActiveAcademyMemberByEmail(data.academyMemberEmail());

        if (!academyMemberActive.isPresent()){
             throw new IntegrityValidation("No se encontró registro de este correo.");
        }


    }
}
