package nc.deveo.fitncbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.domain.utilisateur.Agent;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.AgentRepository;
import nc.deveo.fitncbackend.service.interfaces.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AgentService implements
        WithServiceCreate<Agent>,
        WithServiceUpdate<Agent>,
        WithServicePatch<Agent>,
        WithServiceRead<Agent>,
        WithServiceDelete {

    private final AgentRepository agentRepository;
    private final ObjectMapper objectMapper;

    public Agent findByUid(String uid) {
        return agentRepository.findByUid(uid).orElseThrow(() -> new NotFoundException("L'agent n'a pas été trouvé."));
    }

    @Override
    public Class<Agent> getClazz() {
        return Agent.class;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    public Agent create(Agent entity) {
        return agentRepository.save(entity);
    }

    @Override
    public Agent update(Long id, Agent agent) {
        final Agent agentRead = agentRepository.findById(id).orElseThrow(() -> new NotFoundException("L'agent n'a pas été trouvé."));
        BeanUtils.copyProperties(agent, agentRead);
        return agentRepository.save(agent);
    }

    @Override
    public void delete(Long id) {
        final Agent agent = agentRepository.findById(id).orElseThrow(() -> new NotFoundException("L'agent n'a pas été trouvé."));
        agentRepository.delete(agent);
    }

    @Override
    public Agent patch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        final Agent entityToUpdate = agentRepository.findById(id).orElseThrow(NotFoundException::new);
        final Agent entityPatched = applyPatch(patch, entityToUpdate);
        return agentRepository.save(entityPatched);
    }

    @Override
    public Page<Agent> readPage(Pageable pageable) {
        return agentRepository.findAll(pageable);
    }

    @Override
    public Agent read(Long id) {
        return agentRepository.findById(id).orElseThrow(() -> new NotFoundException("L'agent n'a pas été trouvé."));
    }
}
