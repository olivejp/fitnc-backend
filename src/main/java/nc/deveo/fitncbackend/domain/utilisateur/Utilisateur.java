package nc.deveo.fitncbackend.domain.utilisateur;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.AbstractEntity;
import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.domain.Exercice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Utilisateur extends AbstractEntity {

    @Column(insertable = false, updatable = false)
    protected String dtype;

    @Email
    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String nom;

    @NotNull
    @Column(nullable = false)
    private String prenom;

    private Integer telephone;

    private String urlPhoto;

    @NotNull
    @Column(nullable = false)
    private String uid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;

    @JsonIgnore
    @OneToMany(orphanRemoval = true, mappedBy = "utilisateur")
    private Set<Exercice> exercices;

    @JsonIgnore
    @OneToMany(orphanRemoval = true, mappedBy = "utilisateur")
    private Set<Entrainement> entrainements;

}
