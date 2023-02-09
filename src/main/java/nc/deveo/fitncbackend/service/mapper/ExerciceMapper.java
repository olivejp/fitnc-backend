package nc.deveo.fitncbackend.service.mapper;

import nc.deveo.fitncbackend.domain.Exercice;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.dto.ExerciceDto;
import nc.deveo.fitncbackend.service.SecurityUtils;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ExerciceMapper {

    @Autowired
    private SecurityUtils securityUtils;

    @Named("getUtilisateur")
    public Utilisateur getUtilisateur(ExerciceDto dto) {
        return securityUtils.getUtilisateur();
    }

    @Mappings({
            @Mapping(source = ".", target = "utilisateur", qualifiedByName = "getUtilisateur")
    })
    public abstract Exercice toEntity(ExerciceDto dto);

    public abstract ExerciceDto toDto(Exercice entity);
}
