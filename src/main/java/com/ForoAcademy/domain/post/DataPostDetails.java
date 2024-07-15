package com.ForoAcademy.domain.post;

import java.time.LocalDateTime;

public record DataPostDetails(
        Long id, Long idAcademyMember, LocalDateTime dateTime
) {
    public DataPostDetails(Post post) {
        this(post.getId(), post.getAcademyMember().getId(), post.getCreationDate() );
    }
}
