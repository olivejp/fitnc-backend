package nc.deveo.fitncbackend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories(DatabaseConfiguration.REPOSITORY_PACKAGE)
@EntityScan(DatabaseConfiguration.DOMAIN_PACKAGE)
public class DatabaseConfiguration {
    public static final String REPOSITORY_PACKAGE = "nc.deveo.fitncbackend.repository";
    public static final String DOMAIN_PACKAGE = "nc.deveo.fitncbackend.domain";
}
