package nc.deveo.fitncbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nc.deveo.fitncbackend.enums.TypeEntrainement;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntrainementDto {
    private Long id;
    private String nom;
    private String description;
    private TypeEntrainement typeEntrainement;
    private List<EtapeDto> etapes;
    private Integer rounds;
    private Integer minute;
    private Instant createdDate;
}
