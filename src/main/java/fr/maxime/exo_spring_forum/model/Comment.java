package fr.maxime.exo_spring_forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @SequenceGenerator(name = "comment_id_gen", sequenceName = "message_id_message_seq", allocationSize = 1)
    @EmbeddedId
    private CommentId id;

    @NotNull
    @Column(name = "date_comment", nullable = false)
    private Instant dateComment;

    @Column(name = "comment_message")
    private String commentMessage;

}