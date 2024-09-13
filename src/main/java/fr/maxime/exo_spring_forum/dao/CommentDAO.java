package fr.maxime.exo_spring_forum.dao;

import fr.maxime.exo_spring_forum.model.Comment;
import fr.maxime.exo_spring_forum.model.CommentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, CommentId> {
}
