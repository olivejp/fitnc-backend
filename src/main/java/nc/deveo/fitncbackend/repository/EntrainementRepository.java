package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.Entrainement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrainementRepository extends JpaRepository<Entrainement, Long> {
    Page<Entrainement> findAllByUtilisateur_Uid(String utilisateurUid, Pageable pageable);
    Optional<Entrainement> findByIdAndUtilisateur_Uid(Long id, String utilisateurUid);
    Boolean existsByIdAndUtilisateur_Uid(Long id, String utilisateurUid);
}
