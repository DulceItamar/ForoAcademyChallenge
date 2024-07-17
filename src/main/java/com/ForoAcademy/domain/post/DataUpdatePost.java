package com.ForoAcademy.domain.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUpdatePost(@NotBlank String title,
                             @NotBlank String message,
                             @NotNull Long idPost,
                             @NotNull Long idAuthor


                             ) {
}
