package nc.deveo.fitncbackend.dto;

import lombok.Getter;
import lombok.Setter;
import nc.deveo.fitncbackend.enums.TypeExercice;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ExerciceDto extends AbstractDto {

    private Long id;

    @NotNull
    private String nom;
    private String description;

    @NotNull
    private TypeExercice typeExercice;

    private String groupe;
}
