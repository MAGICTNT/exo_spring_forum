package fr.maxime.exo_spring_forum.service;

import fr.maxime.exo_spring_forum.dao.MessageDAO;
import fr.maxime.exo_spring_forum.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageDAO messageDAO;
    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public List<Message> findAll() {
        return messageDAO.findAll();
    }

    public Message getMessageById(int id) {
        return messageDAO.findById(id).orElse(null);
    }

    public Message FindByLabelMessage(String label) {
        return messageDAO.findByLabelMessage(label);
    }

    public Message saveOrUpdate(Message message) {
        return messageDAO.save(message);
    }

    public void delete(Message message) {
        messageDAO.delete(message);
    }

}
