package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.*;
import nc.deveo.fitncbackend.domain.utilisateur.Agent;
import nc.deveo.fitncbackend.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agent")
public class AgentController implements
        WithControllerCreate<Agent, AgentService>,
        WithControllerUpdate<Agent, AgentService>,
        WithControllerDelete<AgentService>,
        WithControllerRead<Agent, AgentService>,
        WithControllerPatch<Agent, AgentService> {

    private final AgentService agentService;

    @GetMapping("/by-uid/{uid}")
    public ResponseEntity<Agent> findByUid(@PathVariable String uid) {
        return ResponseEntity.ok(agentService.findByUid(uid));
    }

    @Override
    public AgentService getService() {
        return agentService;
    }

}
