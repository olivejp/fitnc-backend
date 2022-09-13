package nc.deveo.fitncbackend.domain.utilisateur;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import nc.deveo.fitncbackend.domain.AbstractIdentifiedEntity;
import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.domain.Exercice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Utilisateur extends AbstractIdentifiedEntity {

    @Column(insertable = false, updatable = false, columnDefinition = "VARCHAR")
    protected String dtype;

    @Email
    @NotNull
    @Column(nullable = false, columnDefinition = "VARCHAR", unique = true)
    private String email;

    @NotNull
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String nom;

    @NotNull
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String prenom;

    private Integer telephone;

    private String urlPhoto;

    @NotNull
    @Column(nullable = false, columnDefinition = "VARCHAR", unique = true)
    private String uid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;

}
