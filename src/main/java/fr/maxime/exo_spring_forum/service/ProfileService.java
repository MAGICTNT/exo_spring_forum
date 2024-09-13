package fr.maxime.exo_spring_forum.service;

import fr.maxime.exo_spring_forum.dao.ProfileDAO;
import fr.maxime.exo_spring_forum.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private ProfileDAO profileDAO;
    public ProfileService(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public List<Profile> getAllProfiles() {
        return profileDAO.findAll();
    }

    public Profile getProfileById(int id) {
        return profileDAO.findById(id).orElse(null);
    }

    public Profile findProfileByLogin(String login) {
        return profileDAO.findByLogin(login);
    }

    public boolean findProfileByLoginAndPassword(String login, String password) {
        return profileDAO.findByLoginAndPassword(login, password) != null;
    }

    public Profile saveOrUpdate(Profile profile) {
        return profileDAO.save(profile);
    }

    public void delete(Profile profile) {
        profileDAO.delete(profile);
    }



}
