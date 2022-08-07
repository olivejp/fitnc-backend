package nc.deveo.fitncbackend.config.security;

import lombok.extern.slf4j.Slf4j;
import nc.deveo.fitncbackend.FitncProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Slf4j
@Configuration
public class WebConfigurer {

    @Bean
    public CorsFilter corsFilter(final FitncProperties properties) {
        log.info("Registering CORS filter");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = properties.getCors();
        final List<String> listOriginsAllowed = config.getAllowedOrigins();
        if (listOriginsAllowed != null && !listOriginsAllowed.isEmpty()) {
            source.registerCorsConfiguration("/api/**", config);
            source.registerCorsConfiguration("/management/**", config);
            source.registerCorsConfiguration("/v2/api-docs", config);
        }
        return new CorsFilter(source);
    }

}
