package nc.deveo.fitncbackend.service.mapper;

import nc.deveo.fitncbackend.domain.etape.Etape;
import nc.deveo.fitncbackend.dto.EtapeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EtapeMapper {
    EtapeDto toDto(Etape etape);
    Etape toEntity(EtapeDto dto);
}
