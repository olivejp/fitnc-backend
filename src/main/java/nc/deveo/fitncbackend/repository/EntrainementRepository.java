package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.Entrainement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrainementRepository extends JpaRepository<Entrainement, Long> {
}
