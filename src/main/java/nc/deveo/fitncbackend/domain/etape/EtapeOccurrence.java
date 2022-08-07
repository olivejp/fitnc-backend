package nc.deveo.fitncbackend.domain.etape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.domain.EntrainementOccurrence;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class EtapeOccurrence extends AbstractEtape {

    @JsonIgnore
    @ManyToOne(optional = false)
    private EntrainementOccurrence entrainementOccurrence;
}