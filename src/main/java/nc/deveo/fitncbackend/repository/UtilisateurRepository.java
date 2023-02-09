package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.utilisateur.Entraineur;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("select (count(u) > 0) from Utilisateur u where upper(u.email) = upper(?1)")
    boolean existsByEmail(String email);
    Optional<Utilisateur> findByUid(String uid);

    Optional<Entraineur> findByEmail(String email);
}
