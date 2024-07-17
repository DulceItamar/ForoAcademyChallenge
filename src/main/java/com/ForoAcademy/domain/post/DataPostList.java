package com.ForoAcademy.domain.post;

import com.ForoAcademy.domain.academyMember.MemberCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record DataPostList(
        Long id,
        String title,
        String message,
        String author,
        @JsonProperty("Member category")
        MemberCategory memberCategory,
        @JsonProperty("Creation date")
        LocalDateTime creationDate

) {
    public DataPostList(Post post){
        this(post.getId(), post.getTitle(), post.getMessage(), post.getAcademyMember().getName(), post.getAcademyMember().getMemberCategory(), post.getCreationDate());
    }
}
