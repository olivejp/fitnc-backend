package nc.deveo.fitncbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nc.deveo.fitncbackend.enums.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EtapeDto {
    private Long id;
    private Integer ordre;
    private String commentaire;
    private TypeEtape typeEtape;
    private String description;
    private Integer tempsRepos;
    private UniteTemps uniteTempsRepos;
    private Integer repetition;
    private Integer poids;
    private Integer temps;
    private UniteTemps uniteTemps;
    private UnitePoids unitePoids;
    private Integer distance;
    private UniteDistance uniteDistance;
}
