package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.utilisateur.Abonnement;
import nc.deveo.fitncbackend.domain.utilisateur.AbonnementIds;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.dto.AbonnementUtilisateurDto;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.AbonnementRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import nc.deveo.fitncbackend.service.mapper.AbonnementMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AbonnementService implements
        WithServiceCreate<Abonnement>,
        WithServiceUpdate<Abonnement>,
        WithServicePatch<Abonnement>,
        WithServiceRead<Abonnement>,
        WithServiceDelete {

    private final AbonnementRepository abonnementRepository;
    private final ObjectMapper objectMapper;
    private final AbonnementMapper abonnementMapper;

    @Override
    public Class<Abonnement> getClazz() {
        return Abonnement.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Abonnement create(Abonnement entity) {
        return abonnementRepository.save(entity);
    }

    @Override
    public Abonnement update(Long id, Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void delete(Long id) {
        final Abonnement abonnement = abonnementRepository.findById(id).orElseThrow(() -> new NotFoundException("L'abonnement n'a pas été trouvé."));
        abonnementRepository.delete(abonnement);
    }

    @Override
    public Abonnement patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Abonnement entityToUpdate = abonnementRepository.findById(id).orElseThrow(NotFoundException::new);
        final Abonnement entityPatched = applyPatch(patch, entityToUpdate);
        return abonnementRepository.save(entityPatched);
    }

    @Override
    public Page<Abonnement> readPage(Pageable pageable) {
        return abonnementRepository.findAll(pageable);
    }

    @Override
    public Abonnement read(Long id) {
        return abonnementRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public AbonnementUtilisateurDto toDto(Abonnement abonnement) {
        return abonnementMapper.toDto(abonnement);
    }

    public List<AbonnementUtilisateurDto> getListAbonnementByEntraineurId(Long idEntraineur) {
        return abonnementRepository.findAllByAbonnementIds_Entraineur_Id(idEntraineur).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Utilisateur getUtilisateurByEntraineurId(Long idEntraineur, Long idUtilisateur) {
        final Abonnement abonnement = abonnementRepository.findAllByAbonnementIds_Entraineur_IdAndAbonnementIds_Utilisateur_Id(idEntraineur, idUtilisateur);
        return abonnement.getAbonnementIds().getUtilisateur();
    }
}
