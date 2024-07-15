package com.ForoAcademy.domain.post;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateAPost(
        @NotBlank
        String title,
        @NotBlank
        String message,

        @JsonProperty("Academy member email")
        @Email
        @NotBlank
        String academyMemberEmail

) {
}
