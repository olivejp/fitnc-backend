package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.service.EntrainementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/entrainement")
public class EntrainementController implements
        WithControllerCreate<Entrainement, EntrainementService>,
        WithControllerUpdate<Entrainement, EntrainementService>,
        WithControllerRead<Entrainement, EntrainementService>,
        WithControllerDelete<EntrainementService>,
        WithControllerPatch<Entrainement, EntrainementService> {

    private final EntrainementService entrainementService;

    @Override
    public EntrainementService getService() {
        return entrainementService;
    }

}
