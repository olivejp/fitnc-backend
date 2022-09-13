package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.utilisateur.Abonnement;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.dto.AbonnementUtilisateurDto;
import nc.deveo.fitncbackend.service.AbonnementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/abonnement")
public class AbonnementController implements
        WithControllerCreate<Abonnement, AbonnementService>,
        WithControllerUpdate<Abonnement, AbonnementService>,
        WithControllerDelete<AbonnementService>,
        WithControllerRead<Abonnement, AbonnementService>,
        WithControllerPatch<Abonnement, AbonnementService> {

    private final AbonnementService abonnementService;

    @Override
    public AbonnementService getService() {
        return abonnementService;
    }

    @GetMapping(path = "by-entraineur-id/{idEntraineur}")
    public ResponseEntity<List<AbonnementUtilisateurDto>> getListAbonnementByEntraineur(@PathVariable Long idEntraineur) {
        return ResponseEntity.ok(abonnementService.getListAbonnementByEntraineurId(idEntraineur));
    }

    @GetMapping(path = "by-entraineur-id/{idEntraineur}/{idUtilisateur}")
    public ResponseEntity<Utilisateur> getUtilisateurByEntraineur(@PathVariable Long idEntraineur,
                                                                  @PathVariable Long idUtilisateur) {
        return ResponseEntity.ok(abonnementService.getUtilisateurByEntraineurId(idEntraineur, idUtilisateur));
    }
}
