package com.ForoAcademy.domain.academyMember;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name= "academy_members")
@Entity(name = "AcademyMember")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class AcademyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private MemberCategory memberCategory;
    private Boolean isActive;


    public AcademyMember(DataSignInAcademyMember academyMember){
        this.name = academyMember.name();
        this.email = academyMember.email();
        this.memberCategory = academyMember.memberCategory();
        this.isActive = true;
    }

    public void disableAcademyMemberAccount(){
        this.isActive = false;
    }

}
