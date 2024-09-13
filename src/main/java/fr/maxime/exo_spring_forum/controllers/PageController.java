package fr.maxime.exo_spring_forum.controllers;

import fr.maxime.exo_spring_forum.model.Message;
import fr.maxime.exo_spring_forum.model.Profile;
import fr.maxime.exo_spring_forum.service.LoginService;
import fr.maxime.exo_spring_forum.service.MessageService;
import fr.maxime.exo_spring_forum.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    private final LoginService loginService;
    private final ProfileService profileService;
    private final MessageService messageService;

    @Autowired
    public PageController(LoginService loginService, ProfileService profileService, MessageService messageService) {
        this.loginService = loginService;
        this.profileService = profileService;
        this.messageService = messageService;

    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("connected", loginService.isLogged());
        return "index";
    }

    @RequestMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("connected", loginService.isLogged());
        model.addAttribute("profile", new Profile());
        return "inscription";
    }


    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("connected", loginService.isLogged());
        return "login";
    }


    @RequestMapping("/profil")
    public String profil(Model model) {
        if (loginService.isLogged()) {
            model.addAttribute("pseudo", loginService.getPseudo());
            return "profil";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        loginService.logout();
        return "redirect:/";
    }

    @RequestMapping("/messages")
    public String messages(Model model) {
        model.addAttribute("messages", messageService.findAll());
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        return "messages";
    }

    @RequestMapping("/newMessage")
    public String newMessage(Model model) {
        model.addAttribute("message", new Message());
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        return "newMessage";
    }
}
