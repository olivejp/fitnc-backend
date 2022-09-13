package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.UtilisateurRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.beancontext.BeanContext;


@Service
@Transactional
@RequiredArgsConstructor
public class UtilisateurService implements
        WithServiceCreate<Utilisateur>,
        WithServiceUpdate<Utilisateur>,
        WithServicePatch<Utilisateur>,
        WithServiceRead<Utilisateur>,
        WithServiceDelete {

    private final UtilisateurRepository utilisateurRepository;
    private final ObjectMapper objectMapper;

    public Utilisateur findByUid(String uid) {
        return utilisateurRepository.findByUid(uid).orElseThrow(() -> new NotFoundException("L'utilisateur n'a pas été trouvé."));
    }

    @Override
    public Class<Utilisateur> getClazz() {
        return Utilisateur.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Utilisateur create(Utilisateur entity) {
        return utilisateurRepository.save(entity);
    }

    @Override
    public Utilisateur update(Long id, Utilisateur utilisateur) {
        final Utilisateur utilisateurRead = utilisateurRepository.findById(id).orElseThrow(() -> new NotFoundException("L'utilisateur n'a pas été trouvé."));
        BeanUtils.copyProperties(utilisateur, utilisateurRead);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void delete(Long id) {
        final Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new NotFoundException("L'utilisateur n'a pas été trouvé."));
        utilisateurRepository.delete(utilisateur);
    }

    @Override
    public Utilisateur patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Utilisateur entityToUpdate = utilisateurRepository.findById(id).orElseThrow(NotFoundException::new);
        final Utilisateur entityPatched = applyPatch(patch, entityToUpdate);
        return utilisateurRepository.save(entityPatched);
    }

    @Override
    public Page<Utilisateur> readPage(Pageable pageable) {
        return utilisateurRepository.findAll(pageable);
    }

    @Override
    public Utilisateur read(Long id) {
        return utilisateurRepository.findById(id).orElseThrow(() -> new NotFoundException("L'utilisateur n'a pas été trouvé."));
    }
}
