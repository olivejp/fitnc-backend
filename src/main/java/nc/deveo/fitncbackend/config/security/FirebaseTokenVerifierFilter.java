package nc.deveo.fitncbackend.config.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class FirebaseTokenVerifierFilter extends OncePerRequestFilter {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final Integer AUTHORIZATION_BEARER_NUMBER_CHARACTER = 7;
    public static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        verifyToken(request);
        filterChain.doFilter(request, response);
    }

    private void verifyToken(HttpServletRequest request) {
        final String token = resolveToken(request);
        if (token != null && !token.isEmpty()) {
            try {
                final FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token);
                final UserSecurity userSecurity = getUserSecurity(firebaseToken);
                final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userSecurity,
                        token, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (FirebaseAuthException e) {
                e.printStackTrace();
                log.error("Firebase Exception: {}", e.getLocalizedMessage());
            }
        } else {
            log.warn("Aucun bearer a décodé.");
        }
    }

    private UserSecurity getUserSecurity(FirebaseToken firebaseToken) {
        return UserSecurity.builder()
                .email(firebaseToken.getEmail())
                .emailVerified(firebaseToken.isEmailVerified())
                .name(firebaseToken.getName())
                .photoUrl(firebaseToken.getPicture())
                .name(firebaseToken.getName())
                .uid(firebaseToken.getUid())
                .build();
    }

    private String resolveToken(HttpServletRequest request) {
        final String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER)) {
            return bearerToken.substring(AUTHORIZATION_BEARER_NUMBER_CHARACTER);
        }
        return null;
    }
}
