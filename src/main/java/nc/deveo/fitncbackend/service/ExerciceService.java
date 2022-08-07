package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.Exercice;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.ExerciceRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExerciceService implements
        WithServiceCreate<Exercice>,
        WithServiceUpdate<Exercice>,
        WithServicePatch<Exercice>,
        WithServiceRead<Exercice>,
        WithServiceDelete {

    private final ExerciceRepository exerciceRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Class<Exercice> getClazz() {
        return Exercice.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Exercice create(Exercice entity) {
        return exerciceRepository.save(entity);
    }

    @Override
    public Exercice update(Long id, Exercice exercice) {
        return exerciceRepository.save(exercice);
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
    public Page<Exercice> readPage(Pageable pageable) {
        return exerciceRepository.findAll(pageable);
    }

    @Override
    public Exercice read(Long id) {
        return exerciceRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
