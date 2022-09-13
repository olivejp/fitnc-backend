package nc.deveo.fitncbackend.domain.etape;

import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.AbstractIdentifiedEntity;
import nc.deveo.fitncbackend.domain.Exercice;
import nc.deveo.fitncbackend.enums.TypeEtape;
import nc.deveo.fitncbackend.enums.UniteDistance;
import nc.deveo.fitncbackend.enums.UnitePoids;
import nc.deveo.fitncbackend.enums.UniteTemps;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEtape extends AbstractIdentifiedEntity {

    @NotNull
    @Column(nullable = false)
    protected Integer ordre;

    protected String commentaire;

    @Enumerated(EnumType.STRING)
    protected TypeEtape typeEtape;

    protected String description;

    protected Integer repetition;



    protected Integer tempsRepos; // Ne devrait être rempli que si c'est un type REPOS

    @Enumerated(EnumType.STRING)
    protected UniteTemps uniteTempsRepos; // Ne devrait être rempli que si c'est un type REPOS



    protected Integer temps;

    @Enumerated(EnumType.STRING)
    protected UniteTemps uniteTemps;



    protected Integer poids;

    @Enumerated(EnumType.STRING)
    protected UnitePoids unitePoids;



    protected Integer distance;

    @Enumerated(EnumType.STRING)
    protected UniteDistance uniteDistance;


    @ManyToOne
    protected Exercice exercice; // Non obligatoire dans le cas d'une étape de repos.
}
