package fr.maxime.exo_spring_forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @ColumnDefault("nextval('message_id_message_seq')")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "label_message", nullable = false, length = 50)
    private String labelMessage;

    @NotNull
    @Column(name = "content_message", nullable = false, length = Integer.MAX_VALUE)
    private String contentMessage;

    @NotNull
    @Column(name = "date_publish", nullable = false)
    private Instant datePublish;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile idProfile;

}