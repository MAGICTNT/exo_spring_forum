package fr.maxime.exo_spring_forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_gen")
    @SequenceGenerator(name = "comment_id_gen", sequenceName = "comment_id_comment_seq", allocationSize = 1)
    @Column(name = "id_comment", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "label_comment", nullable = false, length = 50)
    private String labelComment;

    @NotNull
    @Column(name = "date_comment", nullable = false)
    private Instant dateComment;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_message", nullable = false)
    private Message idMessage;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile idProfile;

}