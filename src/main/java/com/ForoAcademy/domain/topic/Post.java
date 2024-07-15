package com.ForoAcademy.domain.topic;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "Posts")
@Entity(name = "Post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_member_id")
    private AcademyMember academyMember;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Response> responses;

}
