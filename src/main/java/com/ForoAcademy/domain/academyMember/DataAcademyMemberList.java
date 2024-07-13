package com.ForoAcademy.domain.academyMember;

public record DataAcademyMemberList( Long id, String name, String email, String memberCategory, Boolean isActive) {

    public DataAcademyMemberList( AcademyMember academyMember){
        this(academyMember.getId(), academyMember.getName(), academyMember.getEmail(), academyMember.getMemberCategory().toString(), academyMember.getIsActive());
    }

}
