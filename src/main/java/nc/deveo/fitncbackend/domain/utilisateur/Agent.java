package nc.deveo.fitncbackend.domain.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import nc.deveo.fitncbackend.domain.EntrainementOccurrence;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Agent extends Utilisateur {

    @JsonIgnore
    @OneToMany(mappedBy = "agent")
    private Set<EntrainementOccurrence> entrainementOccurrences;

}
