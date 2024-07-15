package com.ForoAcademy.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("""
            SELECT p.title
            FROM Post p
            WHERE p.title=:title
            """)
    List<Post> findByTitle(String title);

    @Query("""
            SELECT p 
            FROM Post p
            WHERE p.academyMember.id = :academyMemberId 
            """)
    List<Post> findByAcademyMemberId(Long academyMemberId);

    @Query("""
            SELECT p 
            FROM Post p
            ORDER BY p.creationDate DESC
            """)
    List<Post> findAllOrderByCreationDateDesc();

    @Query("""
            SELECT p
            FROM Post p
            ORDER BY p.creationData ASC
            """)
    List<Post> findAllOrderByCreationDateAsc();

    @Query("""
            SELECT p
            FROM POST t
            WHERE p.id = : idPost
            """)
    Optional<Post> findById(Long idPost);

}
