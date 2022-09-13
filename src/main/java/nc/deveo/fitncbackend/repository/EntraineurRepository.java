package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.utilisateur.Entraineur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntraineurRepository extends JpaRepository<Entraineur, Long> {
    Optional<Entraineur> findByUid(String uid);
}
