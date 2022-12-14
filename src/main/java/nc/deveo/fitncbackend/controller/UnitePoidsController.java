package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.enums.EnumController;
import nc.deveo.fitncbackend.enums.TypeExercice;
import nc.deveo.fitncbackend.enums.UnitePoids;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/unite-poids")
public class UnitePoidsController {

    @GetMapping
    public List<EnumController> getAll() {
        return Arrays.stream(UnitePoids.values())
                .map(typeExercice -> new EnumController(typeExercice.getLabel(), typeExercice.name()))
                .collect(Collectors.toList());
    }
}
