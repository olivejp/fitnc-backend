package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.Exercice;
import nc.deveo.fitncbackend.dto.ExerciceDto;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.ExerciceRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import nc.deveo.fitncbackend.service.mapper.ExerciceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExerciceService implements
        WithServiceCreate<ExerciceDto>,
        WithServiceUpdate<ExerciceDto>,
        WithServicePatch<Exercice>,
        WithServiceRead<ExerciceDto>,
        WithServiceDelete {

    private final ExerciceRepository exerciceRepository;
    private final ObjectMapper objectMapper;
    private final ExerciceMapper mapper;

    private final SecurityUtils utils;

    @Override
    public Class<Exercice> getClazz() {
        return Exercice.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public ExerciceDto create(ExerciceDto dto) {
        final Exercice exercice = mapper.toEntity(dto);
        exerciceRepository.save(exercice);
        return mapper.toDto(exercice);
    }

    @Override
    public ExerciceDto update(Long id, ExerciceDto dto) {
        final Exercice exercice = mapper.toEntity(dto);
        exerciceRepository.save(exercice);
        return mapper.toDto(exercice);
    }

    @Override
    public void delete(Long id) {
        final Exercice exercice = exerciceRepository.findById(id).orElseThrow(() -> new NotFoundException("L'exercice n'a pas été trouvé."));
        exerciceRepository.delete(exercice);
    }

    @Override
    public Exercice patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Exercice entityToUpdate = exerciceRepository.findById(id).orElseThrow(NotFoundException::new);
        final Exercice entityPatched = applyPatch(patch, entityToUpdate);
        return exerciceRepository.save(entityPatched);
    }

    @Override
    public Page<ExerciceDto> readPage(Pageable pageable) {
        final String uid = utils.getUtilisateur().getUid();
        return exerciceRepository.findAllByUtilisateur_Uid(uid, pageable)
                .map(mapper::toDto);
    }

    @Override
    public ExerciceDto read(Long id) {
        final String uid = utils.getUtilisateur().getUid();
        return exerciceRepository.findByIdAndUtilisateur_Uid(id, uid)
                .map(mapper::toDto)
                .orElseThrow(NotFoundException::new);
    }
}
