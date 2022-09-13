package nc.deveo.fitncbackend.service.mapper;

import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.dto.EntrainementDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = EtapeMapper.class)
public interface EntrainementMapper {
    EntrainementDto toDto(Entrainement entrainement);

    Entrainement toEntity(EntrainementDto dto);
}
