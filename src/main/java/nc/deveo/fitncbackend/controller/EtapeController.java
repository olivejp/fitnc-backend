package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.etape.Etape;
import nc.deveo.fitncbackend.service.EtapeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etape")
public class EtapeController implements
        WithControllerCreate<Etape, EtapeService>,
        WithControllerRead<Etape, EtapeService>,
        WithControllerUpdate<Etape, EtapeService>,
        WithControllerDelete<EtapeService>,
        WithControllerPatch<Etape, EtapeService> {

    private final EtapeService etapeService;

    @Override
    public EtapeService getService() {
        return etapeService;
    }

}
