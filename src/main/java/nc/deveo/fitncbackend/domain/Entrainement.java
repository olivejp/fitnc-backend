package nc.deveo.fitncbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.etape.Etape;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.enums.TypeEntrainement;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Entrainement extends AbstractEntity {

    @Column(insertable = false, updatable = false)
    protected String dtype;

    @NotNull
    @Column(nullable = false)
    protected String nom;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected TypeEntrainement typeEntrainement;

    @OneToMany(orphanRemoval = true, mappedBy = "entrainement")
    protected List<Etape> etapes;

    @JsonIgnore
    @ManyToOne(optional = false)
    protected Utilisateur utilisateur;

    private Integer rounds; // Obligatoire pour le type ROUNDS

    private Integer minute; // Obligatoire pour les types EMOM et AMRAP
}
