package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.enums.EnumController;
import nc.deveo.fitncbackend.enums.TypeEntrainement;
import nc.deveo.fitncbackend.enums.TypeExercice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/type-exercice")
public class TypeExerciceController {

    @GetMapping
    public List<EnumController> getAll() {
        return Arrays.stream(TypeExercice.values())
                .map(typeExercice -> new EnumController(typeExercice.getLabel(), typeExercice.name()))
                .collect(Collectors.toList());
    }
}
