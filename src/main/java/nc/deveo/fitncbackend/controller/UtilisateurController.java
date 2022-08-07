package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.service.UtilisateurService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/utilisateur")
public class UtilisateurController implements
        WithControllerCreate<Utilisateur, UtilisateurService>,
        WithControllerUpdate<Utilisateur, UtilisateurService>,
        WithControllerDelete<UtilisateurService>,
        WithControllerRead<Utilisateur, UtilisateurService>,
        WithControllerPatch<Utilisateur, UtilisateurService> {

    private final UtilisateurService utilisateurService;

    @Override
    public UtilisateurService getService() {
        return utilisateurService;
    }

}
