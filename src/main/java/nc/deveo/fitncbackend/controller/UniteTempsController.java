package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.enums.EnumController;
import nc.deveo.fitncbackend.enums.UnitePoids;
import nc.deveo.fitncbackend.enums.UniteTemps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/unite-temps")
public class UniteTempsController {

    @GetMapping
    public List<EnumController> getAll() {
        return Arrays.stream(UniteTemps.values())
                .map(uniteTemps -> new EnumController(uniteTemps.getLabel(), uniteTemps.name()))
                .collect(Collectors.toList());
    }
}
