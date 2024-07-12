package com.ForoAcademy.domain.topic;

import com.ForoAcademy.domain.academyMember.AcademyMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.Date;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_member_id")
    private AcademyMember academyMember;

    @Enumerated(EnumType.STRING)
    private UnsubscribeReason unsubscribeReason;

}
