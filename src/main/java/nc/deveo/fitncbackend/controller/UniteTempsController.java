package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.enums.EnumDto;
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
    public List<EnumDto> getAll() {
        return Arrays.stream(UniteTemps.values())
                .map(EnumDto::toEnumDto)
                .collect(Collectors.toList());
    }
}
