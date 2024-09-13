package fr.maxime.exo_spring_forum.controllers;

import fr.maxime.exo_spring_forum.model.Profile;
import fr.maxime.exo_spring_forum.service.LoginService;
import fr.maxime.exo_spring_forum.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class InscriptionController {
    private final LoginService loginService;
    private final ProfileService profileService;

    @Autowired
    public InscriptionController(LoginService loginService, ProfileService profileService) {
        this.loginService = loginService;
        this.profileService = profileService;
    }

    @PostMapping("/inscription")
    public String inscription(@Valid @ModelAttribute("profile") Profile profile,
                              BindingResult bindingResult,
                              Model model) throws IOException {

        model.addAttribute("connected", loginService.isLogged());
        if (bindingResult.hasErrors()) {
            return "inscription";
        } else {
            profileService.saveOrUpdate(profile);
            return "redirect:/login";
        }
    }
}
