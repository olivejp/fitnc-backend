package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.utilisateur.Entraineur;
import nc.deveo.fitncbackend.service.EntraineurService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/entraineur")
public class EntraineurController implements
        WithControllerCreate<Entraineur, EntraineurService>,
        WithControllerUpdate<Entraineur, EntraineurService>,
        WithControllerDelete<EntraineurService>,
        WithControllerRead<Entraineur, EntraineurService>,
        WithControllerPatch<Entraineur, EntraineurService> {

    private final EntraineurService entraineurService;

    @GetMapping("/by-uid/{uid}")
    public ResponseEntity<Entraineur> findByUid(@PathVariable String uid) {
        return ResponseEntity.ok(entraineurService.findByUid(uid));
    }

    @Override
    public EntraineurService getService() {
        return entraineurService;
    }

}
