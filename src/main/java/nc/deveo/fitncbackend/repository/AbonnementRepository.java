package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.utilisateur.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
}
