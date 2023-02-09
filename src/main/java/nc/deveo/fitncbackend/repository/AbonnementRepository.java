package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.utilisateur.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    List<Abonnement> findAllByAbonnementIds_Entraineur_Id(Long idEntraineur);

    Abonnement findAllByAbonnementIds_Entraineur_IdAndAbonnementIds_Utilisateur_Id(Long idEntraineur, Long idUtilisateur);
}
