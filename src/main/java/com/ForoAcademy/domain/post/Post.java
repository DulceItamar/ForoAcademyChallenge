package com.ForoAcademy.domain.post;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import com.ForoAcademy.response.Response;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_member_id")
    private AcademyMember academyMember;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Response> responses;

    public void updatePost(DataUpdatePost data) {



        if (data.title() != null) {
            this.title = data.title();
        }

        if (data.message() != null) {
            this.message = data.message();
        }

    }

}
