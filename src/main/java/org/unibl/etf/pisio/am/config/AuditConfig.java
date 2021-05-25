package org.unibl.etf.pisio.am.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.unibl.etf.pisio.am.models.entities.UserEntity;
import org.unibl.etf.pisio.am.services.UserService;

@Configuration
public class AuditConfig {

    private final UserService userService;

    public AuditConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    AuditorAware<UserEntity> auditorProvider() {
        return new AuditorAwareImpl(userService);
    }
}
