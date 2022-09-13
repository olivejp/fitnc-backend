package nc.deveo.fitncbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import nc.deveo.fitncbackend.domain.etape.Etape;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.enums.TypeEntrainement;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Entrainement extends AbstractIdentifiedEntity {

    @NotNull
    @Column(nullable = false)
    protected String nom;

    protected String description;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected TypeEntrainement typeEntrainement;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected List<Etape> etapes;

    @ManyToOne(optional = false)
    protected Utilisateur utilisateur;

    private Integer rounds; // Obligatoire pour le type ROUNDS

    private Integer minute; // Obligatoire pour les types EMOM et AMRAP
}
