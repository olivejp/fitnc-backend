package nc.deveo.fitncbackend.config.security;

import org.springframework.security.core.Authentication;

public interface TokenProvider {
    Authentication getAuthentication(String token);

    boolean validateToken(String authToken);
}
