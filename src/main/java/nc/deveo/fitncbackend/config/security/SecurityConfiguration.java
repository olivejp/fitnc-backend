package nc.deveo.fitncbackend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String EXTERNAL_API_PREFIX = "/api/**";

    @Bean
    public FirebaseTokenVerifierFilter securityFilter() {
        return new FirebaseTokenVerifierFilter();
    }

    @Bean
    public Http401UnauthorizedEntryPoint securityException401EntryPoint() {
        return new Http401UnauthorizedEntryPoint();
    }

    @Override
    public void configure(WebSecurity web) {
        // Not implemented
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(securityException401EntryPoint())
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/alive").permitAll()
                .antMatchers("/i18n/**").permitAll()
                .antMatchers("/content/**").permitAll()
                .antMatchers("/swagger-ui/index.html").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/b2b/jobs/**").permitAll()
                .antMatchers("/management/health").permitAll()
                .antMatchers("/management/info").permitAll()
                .antMatchers("/management/configuration").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .antMatchers("/swagger-resources/configuration/ui").permitAll()
                .antMatchers("/swagger-ui/index.html").permitAll()
                .antMatchers(EXTERNAL_API_PREFIX).authenticated()
                .and()
                .addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
