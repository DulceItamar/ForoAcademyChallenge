package com.ForoAcademy.domain.post;

import com.ForoAcademy.domain.academyMember.MemberCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataDeletePost(
        @JsonProperty("Post id")
        @NotNull Long idPost,
        @JsonProperty("Motivo de eliminación")
        @NotBlank String DeletingReason,
        @JsonProperty("Categoría")
        @NotNull MemberCategory memberCategory) {
}
