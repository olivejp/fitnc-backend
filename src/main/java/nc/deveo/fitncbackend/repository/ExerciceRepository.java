package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.Exercice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
    Page<Exercice> findAllByUtilisateur_Uid(String utilisateurUid, Pageable pageable);
    Optional<Exercice> findByIdAndUtilisateur_Uid(Long id, String utilisateurUid);
}
