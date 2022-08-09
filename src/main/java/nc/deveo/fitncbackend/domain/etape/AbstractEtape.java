package nc.deveo.fitncbackend.domain.etape;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    protected Integer tempsRepos; // Ne devrait être rempli que si c'est un type REPOS

    protected UniteTemps uniteTempsRepos; // Ne devrait être rempli que si c'est un type REPOS

    protected Integer repetition;

    protected Integer poids;

    protected Integer temps;

    protected UniteTemps uniteTemps;

    protected UnitePoids unitePoids;

    protected Integer distance;

    protected UniteDistance uniteDistance;

    @JsonIgnore
    @ManyToOne
    protected Exercice exercice; // Non obligatoire dans le cas d'une étape de repos.
}
