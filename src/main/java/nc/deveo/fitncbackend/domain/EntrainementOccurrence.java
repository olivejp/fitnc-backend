package nc.deveo.fitncbackend.domain;

import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.utilisateur.Agent;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class EntrainementOccurrence extends AbstractIdentifiedEntity {

    private LocalDateTime datePrevue;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    @ManyToOne(optional = false)
    private Agent agent;

    @ManyToOne
    private Entrainement entrainement;
}