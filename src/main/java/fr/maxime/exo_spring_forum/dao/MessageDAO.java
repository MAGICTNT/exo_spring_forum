package fr.maxime.exo_spring_forum.dao;

import fr.maxime.exo_spring_forum.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDAO extends JpaRepository<Message, Integer> {
    public Message findByLabelMessage(String labelMessage);
}
