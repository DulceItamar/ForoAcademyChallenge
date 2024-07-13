package com.ForoAcademy.domain.academyMember;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataSignInAcademyMember(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @JsonProperty("member category")
        @NotNull
        MemberCategory memberCategory

) {
}
