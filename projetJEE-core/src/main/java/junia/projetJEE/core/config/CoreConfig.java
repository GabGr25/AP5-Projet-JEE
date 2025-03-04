package junia.projetJEE.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "junia.projetJEE.core.dao")
@EntityScan(basePackages = "junia.projetJEE.core.entity")
@ComponentScan(basePackages = "junia.projetJEE.core.service")
public class CoreConfig {
}

