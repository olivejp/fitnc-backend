package nc.deveo.fitncbackend.config.security;

import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import nc.opt.bp.config.OptSecurityConfiguration;
import nc.opt.bp.security.UserOPT;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Primary
@Log4j2
@Component("jwtTokenProvider")
public class JWTTokenProvider implements TokenProvider {

    private static final String UID_KEY = "uid";
    private static final String NOM_KEY = "nom";
    private static final String PRENOM_KEY = "prenom";
    private static final String ROLES_KEY = "roles";
    private static final String RESSOURCES_KEY = "ressources";

    private PublicKey publicKey;

    @PostConstruct
    public void init() {
        final String pathPublicKey = optSecurityConfiguration.getPathPublicKey();

        log.info("Starting up TokenProvider with public key path [opt.security.pathPublicKey] = {}", pathPublicKey);

        try (InputStream inputStream = new FileInputStream(ResourceUtils.getFile((pathPublicKey)))) {

            X509EncodedKeySpec spec = new X509EncodedKeySpec(IOUtils.toByteArray(inputStream));

            KeyFactory kf = KeyFactory.getInstance("RSA");
            this.publicKey = kf.generatePublic(spec);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new SecurityException("Erreur lors de la lecture de la clé publique JWT", e);
        }

        log.info("Started token provider with public key {}", pathPublicKey);
    }

    @Override
    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();

        @SuppressWarnings("unchecked")
        List<String> roles = claims.get(ROLES_KEY, List.class);

        List<? extends GrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        @SuppressWarnings("unchecked")
        Map<String, List<String>> resources = (Map<String, List<String>>) claims.get(RESSOURCES_KEY);

        var principal = new UserOPT(
                claims.get(UID_KEY).toString(),
                claims.get(NOM_KEY).toString(),
                claims.get(PRENOM_KEY).toString(),
                authorities,
                resources
        );

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    @Override
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(publicKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {0}", e);
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace: {0}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {0}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {0}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {0}", e);
        }
        return false;
    }
}
