package fr.maxime.exo_spring_forum.service;


import org.springframework.stereotype.Service;

@Service
public class CommentService {

//    private final CommentDAO commentDAO;
//    private final MessageDAO messageDAO;
//    private final ProfileDAO profileDAO;
//    @Autowired
//    public CommentService(CommentDAO commentDAO, MessageDAO messageDAO, ProfileDAO profileDAO) {
//        this.commentDAO = commentDAO;
//        this.messageDAO = messageDAO;
//        this.profileDAO = profileDAO;
//    }
//
  ////   Méthode pour obtenir un commentaire par son ID
//    public Optional<Comment> getCommentById(CommentId id) {
//        return commentDAO.findById(id);
//    }
//
  ////   Méthode pour obtenir tous les commentaires
//    public List<Comment> getAllComments() {
//        return commentDAO.findAll();
//    }
//
  ////   Méthode pour créer ou mettre à jour un commentaire
//    public Comment saveComment(Comment comment) {
//        return commentDAO.save(comment);
//    }
//
 ////    Méthode pour supprimer un commentaire par son ID
//    public void deleteCommentById(CommentId id) {
//        commentDAO.deleteById(id);
//    }
//
//    public List<Comment> getAllCommentByIdMessageAndIdProfile(int idMessage, int idProfile) {
//        List<Comment> listComment = new ArrayList<>();
//        Message message = messageDAO.findById(idMessage).orElse(null);
//        Profile profile = profileDAO.findById(idProfile).orElse(null);
//        if (message != null && profile != null) {
//            CommentId commentId = new CommentId();
//            commentId.setIdMessage(message.getId());
//            commentId.setIdProfile(profile.getId());
//            Comment comment = commentDAO.findById(commentId).orElse(null);
//            return commentDAO.findAllById((Iterable<CommentId>) comment.getId());
//        }
//        return listComment;
//    }
}
