package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.etape.Etape;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.EtapeRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EtapeService implements
        WithServiceRead<Etape>,
        WithServiceCreate<Etape>,
        WithServiceUpdate<Etape>,
        WithServicePatch<Etape>,
        WithServiceDelete {

    private final EtapeRepository etapeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Class<Etape> getClazz() {
        return Etape.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Etape create(Etape entity) {
        return etapeRepository.save(entity);
    }

    @Override
    public Etape update(Long id, Etape etape) {
        return etapeRepository.save(etape);
    }

    @Override
    public void delete(Long id) {
        final Etape etape = etapeRepository.findById(id).orElseThrow(() -> new NotFoundException("L'etape n'a pas été trouvé."));
        etapeRepository.delete(etape);
    }

    @Override
    public Etape patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Etape entityToUpdate = etapeRepository.findById(id).orElseThrow(NotFoundException::new);
        final Etape entityPatched = applyPatch(patch, entityToUpdate);
        return etapeRepository.save(entityPatched);
    }

    @Override
    public Page<Etape> readPage(Pageable pageable) {
        return etapeRepository.findAll(pageable);
    }

    @Override
    public Etape read(Long id) {
        return etapeRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
