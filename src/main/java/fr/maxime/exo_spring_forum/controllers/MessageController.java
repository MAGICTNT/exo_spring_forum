package fr.maxime.exo_spring_forum.controllers;

import fr.maxime.exo_spring_forum.model.Message;
import fr.maxime.exo_spring_forum.service.LoginService;
import fr.maxime.exo_spring_forum.service.MessageService;
import fr.maxime.exo_spring_forum.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class MessageController {
    private final LoginService loginService;
    private final MessageService messageService;
    private final ProfileService profileService;
    public MessageController(LoginService loginService, MessageService messageService, ProfileService profileService) {
        this.loginService = loginService;
        this.messageService = messageService;
        this.profileService = profileService;
    }

    @PostMapping("/newMessage")
    public String newMessage(@Valid @ModelAttribute("message") Message message,
                              BindingResult bindingResult,
                              Model model) throws IOException {

        model.addAttribute("connected", loginService.isLogged());
        message.setIdProfile(profileService.findProfileByLogin(loginService.getPseudo()));
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "newMessage";
        } else {
            System.out.println(message);
            messageService.saveOrUpdate(message);
            return "redirect:/messages";
        }
    }
}
