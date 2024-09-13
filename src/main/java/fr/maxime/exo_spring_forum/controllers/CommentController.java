package fr.maxime.exo_spring_forum.controllers;

import fr.maxime.exo_spring_forum.model.Message;
import fr.maxime.exo_spring_forum.service.LoginService;
import fr.maxime.exo_spring_forum.service.MessageService;
import fr.maxime.exo_spring_forum.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    private final LoginService loginService;
    private final MessageService messageService;
//    private final CommentService commentService;
    private final ProfileService profileService;

    public CommentController(MessageService messageService,
//                             CommentService commentService,
                             ProfileService profileService, LoginService loginService) {
        this.messageService = messageService;
//        this.commentService = commentService;
        this.profileService = profileService;
        this.loginService = loginService;
    }

    // Afficher le formulaire de commentaire pour un message
    @RequestMapping("/commentMessage/id={id}")
    public String commentMessage(Model model, @PathVariable Integer id) {
        Message message = messageService.getMessageById(id);

        if (message != null) {
            model.addAttribute("message", message);

            return "commentMessage";
        }
        return "error"; // Si le message n'est pas trouvé
    }

    // Gérer l'ajout d'un commentaire
    @PostMapping("/AddCommentMessage/id={id}")
    public String addComment(@PathVariable Integer id, @RequestParam("commentText") String commentText) {

        Message message = messageService.getMessageById(id);
        if (message != null) {
//            CommentId newComment = new CommentId();
//            newComment.setIdMessage(id);
//            newComment.setIdProfile(profileService.findProfileByLogin(loginService.getPseudo()).getId());
//            Comment comment = new Comment();
//            comment.setId(newComment);
//            comment.setDateComment(Instant.now());
//            comment.setCommentMessage(commentText);
//            commentService.saveComment(comment);

            return "redirect:/commentMessage/id=" + id;
        }
        return "redirect:/"; // Si le message n'est pas trouvé
    }
}
