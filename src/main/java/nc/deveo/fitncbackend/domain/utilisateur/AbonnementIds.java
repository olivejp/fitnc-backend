package nc.deveo.fitncbackend.domain.utilisateur;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Embeddable
public class AbonnementIds implements Serializable {

    @OneToOne(optional = false)
    @JoinColumn(nullable = false, name = "entraineur_id")
    public Entraineur entraineur;

    @OneToOne(optional = false)
    @JoinColumn(nullable = false, name = "utilisateur_id")
    public Utilisateur utilisateur;
}
