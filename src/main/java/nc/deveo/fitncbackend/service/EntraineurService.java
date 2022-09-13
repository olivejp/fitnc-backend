package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.utilisateur.Entraineur;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.EntraineurRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class EntraineurService implements
        WithServiceCreate<Entraineur>,
        WithServiceUpdate<Entraineur>,
        WithServicePatch<Entraineur>,
        WithServiceRead<Entraineur>,
        WithServiceDelete {

    private final EntraineurRepository entraineurRepository;
    private final ObjectMapper objectMapper;

    public Entraineur findByUid(String uid) {
        return entraineurRepository.findByUid(uid).orElseThrow(() -> new NotFoundException("L'entraineur n'a pas été trouvé."));
    }

    @Override
    public Class<Entraineur> getClazz() {
        return Entraineur.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Entraineur create(Entraineur entity) {
        return entraineurRepository.save(entity);
    }

    @Override
    public Entraineur update(Long id, Entraineur entraineur) {
        final Entraineur entraineurRead = entraineurRepository.findById(id).orElseThrow(() -> new NotFoundException("L'entraineur n'a pas été trouvé."));
        BeanUtils.copyProperties(entraineur, entraineurRead);
        return entraineurRepository.save(entraineur);
    }

    @Override
    public void delete(Long id) {
        final Entraineur entraineur = entraineurRepository.findById(id).orElseThrow(() -> new NotFoundException("L'entraineur n'a pas été trouvé."));
        entraineurRepository.delete(entraineur);
    }

    @Override
    public Entraineur patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Entraineur entityToUpdate = entraineurRepository.findById(id).orElseThrow(NotFoundException::new);
        final Entraineur entityPatched = applyPatch(patch, entityToUpdate);
        return entraineurRepository.save(entityPatched);
    }

    @Override
    public Page<Entraineur> readPage(Pageable pageable) {
        return entraineurRepository.findAll(pageable);
    }

    @Override
    public Entraineur read(Long id) {
        return entraineurRepository.findById(id).orElseThrow(() -> new NotFoundException("L'entraineur n'a pas été trouvé."));
    }
}
