package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.utilisateur.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
}
