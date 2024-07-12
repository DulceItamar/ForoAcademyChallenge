package com.ForoAcademy.domain.user;

import com.ForoAcademy.domain.academyMember.MemberCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String username);
}
