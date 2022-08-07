package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
}
