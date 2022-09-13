package nc.deveo.fitncbackend.dto;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class AbonnementUtilisateurDto {
    Long id;
    String email;
    String nom;
    String prenom;
    LocalDate dateNaissance;
    Instant createdDate;
    Instant updatedDate;
}
