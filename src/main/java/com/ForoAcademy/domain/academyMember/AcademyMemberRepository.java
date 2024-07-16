package com.ForoAcademy.domain.academyMember;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AcademyMemberRepository extends JpaRepository<AcademyMember, Long> {
    Page<AcademyMember> findAllByIsActiveTrue(Pageable pageable);

    @Query("""
            SELECT member 
            FROM AcademyMember member
            WHERE member.email = :AcademyMemberEmail AND member.isActive = TRUE
            """)
    Optional<AcademyMember> findIsActiveAcademyMemberByEmail( String AcademyMemberEmail);




}
