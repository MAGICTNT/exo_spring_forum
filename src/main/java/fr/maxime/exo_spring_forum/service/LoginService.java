package fr.maxime.exo_spring_forum.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;

    public boolean login(boolean status,String pseudo) {
        if (status) {
            httpSession.setAttribute("login", "ok");
            httpSession.setAttribute("pseudo", pseudo);
            return true;
        }
        return false;
    }

    public boolean isLogged() {
        try {
            String isOk = (String) httpSession.getAttribute("login");
            return isOk.equals("ok");
        }catch (Exception e) {
            return false;
        }
    }
    public String getPseudo() {
        return (String) httpSession.getAttribute("pseudo");
    }

    public void logout() {
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("pseudo");
    }
}
