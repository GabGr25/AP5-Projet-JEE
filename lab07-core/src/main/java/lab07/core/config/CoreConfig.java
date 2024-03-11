package lab07.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "lab07.core.dao")
@EntityScan(basePackages = "lab07.core.entity")
@ComponentScan(basePackages = "lab07.core.service")
public class CoreConfig {
}
