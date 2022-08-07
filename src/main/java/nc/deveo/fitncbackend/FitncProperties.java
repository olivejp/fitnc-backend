package nc.deveo.fitncbackend;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@Getter
@Setter
@ConfigurationProperties(prefix = "fitnc")
public class FitncProperties {
    private String firebaseAdminKey;
    private final CorsConfiguration cors = new CorsConfiguration();
}
