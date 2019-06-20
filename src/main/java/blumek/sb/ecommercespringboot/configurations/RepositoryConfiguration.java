package blumek.sb.ecommercespringboot.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"blumek.sb.ecommercespringboot.models"})
@EnableJpaRepositories(basePackages = {"blumek.sb.ecommercespringboot.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
