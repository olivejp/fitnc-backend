package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerCreate;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerDelete;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerRead;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerUpdate;
import nc.deveo.fitncbackend.dto.EntrainementDto;
import nc.deveo.fitncbackend.service.EntrainementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/entrainement")
public class EntrainementController implements
        WithControllerCreate<EntrainementDto, EntrainementService>,
        WithControllerUpdate<EntrainementDto, EntrainementService>,
        WithControllerRead<EntrainementDto, EntrainementService>,
        WithControllerDelete<EntrainementService> {

    private final EntrainementService entrainementService;

    @Override
    public EntrainementService getService() {
        return entrainementService;
    }

}
