package com.ForoAcademy.domain.academyMember;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AcademyMemberRepository extends JpaRepository<AcademyMember, Long> {
    Page<AcademyMember> findAllByIsActiveTrue(Pageable pageable);

    @Query("""
            select member.isActive
            from AcademyMember member
            where member.id=:idAcademyMember
            """)
    Boolean findIsActiveById(Long idAcademyMember);
}
