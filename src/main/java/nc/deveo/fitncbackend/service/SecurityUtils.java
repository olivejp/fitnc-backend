package nc.deveo.fitncbackend.service;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.config.security.UserSecurity;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.repository.UtilisateurRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUtils {
    private final UtilisateurRepository utilisateurRepository;

    public Utilisateur getUtilisateur() {
        final String email = ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
        return utilisateurRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(String.format("Utilisateur non trouvé pour l'email : %s", email)));
    }
}
