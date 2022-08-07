package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.EntrainementRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EntrainementService implements
        WithServiceRead<Entrainement>,
        WithServiceCreate<Entrainement>,
        WithServiceUpdate<Entrainement>,
        WithServicePatch<Entrainement>,
        WithServiceDelete {

    private final EntrainementRepository entrainementRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Class<Entrainement> getClazz() {
        return Entrainement.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Entrainement create(Entrainement entity) {
        return entrainementRepository.save(entity);
    }

    @Override
    public Entrainement update(Long id, Entrainement entrainement) {
        return entrainementRepository.save(entrainement);
    }

    @Override
    public void delete(Long id) {
        final Entrainement entrainement = entrainementRepository.findById(id).orElseThrow(() -> new NotFoundException("L'entrainement n'a pas été trouvé."));
        entrainementRepository.delete(entrainement);
    }

    @Override
    public Entrainement patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Entrainement entityToUpdate = entrainementRepository.findById(id).orElseThrow(NotFoundException::new);
        final Entrainement entityPatched = applyPatch(patch, entityToUpdate);
        return entrainementRepository.save(entityPatched);
    }

    @Override
    public Page<Entrainement> readPage(Pageable pageable) {
        return entrainementRepository.findAll(pageable);
    }

    @Override
    public Entrainement read(Long id) {
        return entrainementRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
