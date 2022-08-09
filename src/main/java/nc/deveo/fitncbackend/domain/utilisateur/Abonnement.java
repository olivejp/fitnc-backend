package nc.deveo.fitncbackend.domain.utilisateur;

import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.AbstractEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Abonnement extends AbstractEntity {

    @EmbeddedId
    private AbonnementIds abonnementIds;
}
