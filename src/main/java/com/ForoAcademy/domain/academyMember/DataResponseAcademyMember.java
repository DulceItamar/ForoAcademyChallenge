package com.ForoAcademy.domain.academyMember;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataResponseAcademyMember(

        Long id,
        String name,
        String email,
        @JsonProperty("member category")
        MemberCategory memberCategory,
        @JsonProperty("active")
        Boolean isActive

) {
}
