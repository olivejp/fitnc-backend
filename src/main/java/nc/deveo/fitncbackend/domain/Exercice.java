package nc.deveo.fitncbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.enums.TypeExercice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Exercice extends AbstractIdentifiedEntity {

    @NotNull
    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeExercice typeExercice;

    private String groupe;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    private String description;
}
