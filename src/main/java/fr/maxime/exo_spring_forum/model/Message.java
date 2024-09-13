package fr.maxime.exo_spring_forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_gen")
    @SequenceGenerator(name = "message_id_gen", sequenceName = "message_id_message_seq", allocationSize = 1)
    @Column(name = "id_message", nullable = false)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    @NotNull(message = "le label dois faire maximum 50 caractere")
    @Column(name = "label_message", nullable = false, length = 50)
    private String labelMessage;

    @NotBlank
    @NotNull
    @Column(name = "content_message", nullable = false, length = Integer.MAX_VALUE)
    private String contentMessage;


    @Column(name = "date_publish", nullable = false)
    private LocalDate datePublish;

    @Column(name = "id_profile")
    private int idProfile;

    // Méthode appelée avant la persistance de l'entité
    @PrePersist
    public void prePersist() {
        this.datePublish = LocalDate.now(); // Auto-générer la date actuelle
    }
}