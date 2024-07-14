package com.ForoAcademy.domain.academyMember;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataAcademyMemberUpdate(
        Long id,
        String name,
        String email
) {
}
