package com.ForoAcademy.domain.topic;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;

import java.time.LocalDateTime;

@Table(name = "responses")
@Entity(name = "Response")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_author_id")
    AcademyMember author;
    String message;
    LocalDateTime creationDate;

}
