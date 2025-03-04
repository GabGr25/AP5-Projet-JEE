package junia.projetJEE.data.config;

import junia.projetJEE.core.config.CoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
public class DataConfig {
}
