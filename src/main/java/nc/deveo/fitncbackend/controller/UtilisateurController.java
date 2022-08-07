package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/utilisateur")
public class UtilisateurController implements
        WithControllerCreate<Utilisateur, UtilisateurService>,
        WithControllerUpdate<Utilisateur, UtilisateurService>,
        WithControllerDelete<UtilisateurService>,
        WithControllerRead<Utilisateur, UtilisateurService>,
        WithControllerPatch<Utilisateur, UtilisateurService> {

    private final UtilisateurService utilisateurService;

    @GetMapping("/by-uid/{uid}")
    public ResponseEntity<Utilisateur> findByUid(@PathVariable String uid) {
        return ResponseEntity.ok(utilisateurService.findByUid(uid));
    }

    @Override
    public UtilisateurService getService() {
        return utilisateurService;
    }

}
