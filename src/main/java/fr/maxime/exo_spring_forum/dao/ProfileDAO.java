package fr.maxime.exo_spring_forum.dao;
import fr.maxime.exo_spring_forum.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDAO extends JpaRepository<Profile, Integer> {
    Profile findByLogin(String login);
    Profile findByLoginAndPassword(String login, String password);
}
