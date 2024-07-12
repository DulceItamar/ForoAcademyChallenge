package com.ForoAcademy.domain.academyMember;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataResponseAcademyMember(

        String name,
        
        String email,

        @JsonProperty("member category")
        MemberCategory memberCategory,

        @JsonProperty("active")
        Boolean isActive

) {
}
