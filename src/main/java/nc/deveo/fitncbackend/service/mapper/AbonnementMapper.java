package nc.deveo.fitncbackend.service.mapper;

import nc.deveo.fitncbackend.domain.utilisateur.Abonnement;
import nc.deveo.fitncbackend.dto.AbonnementUtilisateurDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AbonnementMapper {
    @Mapping(source = "abonnementIds.utilisateur.id", target = "id")
    @Mapping(source = "abonnementIds.utilisateur.nom", target = "nom")
    @Mapping(source = "abonnementIds.utilisateur.prenom", target = "prenom")
    @Mapping(source = "abonnementIds.utilisateur.dateNaissance", target = "dateNaissance")
    @Mapping(source = "abonnementIds.utilisateur.email", target = "email")
    @Mapping(source = "abonnementIds.utilisateur.createdDate", target = "createdDate")
    @Mapping(source = "abonnementIds.utilisateur.updatedDate", target = "updatedDate")
    AbonnementUtilisateurDto toDto(Abonnement abonnement);
}
