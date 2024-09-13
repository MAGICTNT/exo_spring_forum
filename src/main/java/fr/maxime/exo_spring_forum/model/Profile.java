package fr.maxime.exo_spring_forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @ColumnDefault("nextval('profile_id_profile_seq')")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile", nullable = false)
    private Integer id;

    @NotBlank
    @NotNull
    @Size(max = 50, min = 4, message = "login entre 4 et 50 caractere")
    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @NotBlank
    @NotNull(message = "votre mot de passe ne peux pas etre vide")
    @Size(max = 50, min = 4 , message = "mode de passe entre 4 et 50 caractere")
    @Column(name = "password", length = 50)
    private String password;

}
//package fr.maxime.exo_spring_forum.model;
//
//import jakarta.persistence.*;
//        import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "profile")
//public class Profile {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_id_gen")
//    @SequenceGenerator(name = "profile_id_gen", sequenceName = "profile_id_profile_seq", allocationSize = 1)
//    @Column(name = "id_profile", nullable = false)
//    private Integer id;
//
//    @NotBlank
//    @NotNull
//    @Size(max = 50, min = 4, message = "login entre 4 et 50 caractere")
//    @Column(name = "login", nullable = false, length = 50)
//    private String login;
//
//    @NotBlank
//    @NotNull(message = "votre mot de passe ne peux pas etre vide")
//    @Size(max = 50, min = 4 , message = "mode de passe entre 4 et 50 caractere")
//    @Column(name = "password", length = 50)
//    private String password;
//
//}