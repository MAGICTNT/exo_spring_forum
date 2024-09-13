package fr.maxime.exo_spring_forum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CommentId implements Serializable {
    private static final long serialVersionUID = -3534324081859390261L;
    @NotNull
    @Column(name = "id_message", nullable = false)
    private Integer idMessage;

    @NotNull
    @Column(name = "id_profile", nullable = false)
    private Integer idProfile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommentId entity = (CommentId) o;
        return Objects.equals(this.idProfile, entity.idProfile) &&
                Objects.equals(this.idMessage, entity.idMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfile, idMessage);
    }

}