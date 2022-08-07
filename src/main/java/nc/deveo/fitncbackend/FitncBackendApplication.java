package nc.deveo.fitncbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FitncBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitncBackendApplication.class, args);
    }

}
