package nc.deveo.fitncbackend.service;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.config.security.UserSecurity;
import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.dto.EntrainementDto;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.EntrainementRepository;
import nc.deveo.fitncbackend.service.interfaces.WithServiceCreate;
import nc.deveo.fitncbackend.service.interfaces.WithServiceDelete;
import nc.deveo.fitncbackend.service.interfaces.WithServiceRead;
import nc.deveo.fitncbackend.service.interfaces.WithServiceUpdate;
import nc.deveo.fitncbackend.service.mapper.EntrainementMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EntrainementService implements
        WithServiceRead<EntrainementDto>,
        WithServiceCreate<EntrainementDto>,
        WithServiceUpdate<EntrainementDto>,
        WithServiceDelete {

    private final EntrainementRepository entrainementRepository;
    private final UtilisateurService utilisateurService;
    private final EntrainementMapper mapper;

    public List<EntrainementDto> getFromDateTime(LocalDate date) {
        final Utilisateur utilisateur = utilisateurService.findByUid(getCurrentUid());
        final Instant dateStartDay = date.atStartOfDay().toInstant(ZoneOffset.UTC);
        final Instant dateEndDay = date.atTime(LocalTime.MIDNIGHT).toInstant(ZoneOffset.UTC);
        return entrainementRepository.findAllByUtilisateur_UidAndCreatedDateBetween(utilisateur.getUid(), dateStartDay, dateEndDay)
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EntrainementDto create(EntrainementDto dto) {
        final Utilisateur utilisateur = utilisateurService.findByUid(getCurrentUid());
        final Entrainement entrainement = mapper.toEntity(dto);
        entrainement.setUtilisateur(utilisateur);
        return mapper.toDto(entrainementRepository.save(entrainement));
    }

    @Override
    public EntrainementDto update(Long id, EntrainementDto dto) {
        final String utilisateurUid = getCurrentUid();
        final Entrainement entrainementRead = entrainementRepository.findByIdAndUtilisateur_Uid(id, utilisateurUid).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(dto, entrainementRead, "createdDate");
        entrainementRepository.save(entrainementRead);
        return mapper.toDto(entrainementRead);
    }

    @Override
    public void delete(Long id) {
        final Entrainement entrainement = entrainementRepository.findByIdAndUtilisateur_Uid(id, getCurrentUid()).orElseThrow(() -> new NotFoundException("L'entrainement n'a pas été trouvé."));
        entrainementRepository.delete(entrainement);
    }

    @Override
    public Page<EntrainementDto> readPage(Pageable pageable) {
        return entrainementRepository.findAllByUtilisateur_Uid(getCurrentUid(), pageable).map(mapper::toDto);
    }

    @Override
    public EntrainementDto read(Long id) {
        return entrainementRepository.findByIdAndUtilisateur_Uid(id, getCurrentUid()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    private String getCurrentUid() {
        final UserSecurity principal = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUid();
    }
}
