package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.etape.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Long> {
}
