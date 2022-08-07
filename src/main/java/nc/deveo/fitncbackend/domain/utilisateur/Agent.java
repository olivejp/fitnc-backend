package nc.deveo.fitncbackend.domain.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.EntrainementOccurrence;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Agent extends Utilisateur {

    @JsonIgnore
    @OneToMany(mappedBy = "agent")
    private Set<EntrainementOccurrence> entrainementOccurrences;

}
