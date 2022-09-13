package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.domain.utilisateur.Entraineur;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.dto.EntrainementDto;
import nc.deveo.fitncbackend.enums.TypeEntrainement;
import nc.deveo.fitncbackend.repository.EntrainementRepository;
import nc.deveo.fitncbackend.repository.EntraineurRepository;
import nc.deveo.fitncbackend.repository.UtilisateurRepository;
import nc.deveo.fitncbackend.service.EntrainementService;
import nc.deveo.fitncbackend.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alive")
public class AliveController {

    private final EntraineurRepository entraineurRepository;
    private final EntrainementService entrainementRepository;

    @GetMapping
    public ResponseEntity<Boolean> isAlive() {
        return ResponseEntity.ok(true);
    }

    @PostMapping
    public ResponseEntity<Boolean> initDatabase() {
        final Entraineur entraineur = Entraineur.builder()
                .nom("OLIVE")
                .prenom("Jean Paul")
                .email("orlanth23@gmail.com")
                .dateNaissance(LocalDate.of(1984, 3, 23))
                .uid("test")
                .build();
        entraineurRepository.save(entraineur);

        final EntrainementDto entrainement = EntrainementDto.builder()
                .nom("OLIVE")
                .minute(5)
                .typeEntrainement(TypeEntrainement.AMRAP)
                .build();
        entrainementRepository.create(entrainement);

        return ResponseEntity.ok(true);
    }

}
