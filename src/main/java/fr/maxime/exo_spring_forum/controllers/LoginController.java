package fr.maxime.exo_spring_forum.controllers;

import fr.maxime.exo_spring_forum.service.LoginService;
import fr.maxime.exo_spring_forum.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final ProfileService profileService;

    @Autowired
    public LoginController(LoginService loginService, ProfileService profileService) {
        this.loginService = loginService;
        this.profileService = profileService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login, @RequestParam("password") String password) {

        System.out.println(profileService.findProfileByLoginAndPassword(login, password));
        if (profileService.findProfileByLoginAndPassword(login, password)) {
            loginService.login(true, login);
            return "redirect:/profil";
        }else {
            return "redirect:/login";
        }
    }


}
