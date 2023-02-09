package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.Exercice;
import nc.deveo.fitncbackend.dto.ExerciceDto;
import nc.deveo.fitncbackend.service.ExerciceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exercice")
public class ExerciceController implements
        WithControllerCreate<ExerciceDto, ExerciceService>,
        WithControllerUpdate<ExerciceDto, ExerciceService>,
        WithControllerRead<ExerciceDto, ExerciceService>,
        WithControllerDelete<ExerciceService>,
        WithControllerPatch<Exercice, ExerciceService> {

    private final ExerciceService exerciceService;

    @Override
    public ExerciceService getService() {
        return exerciceService;
    }

}
