package com.wallisonlemos.multidb.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AuthFlywayConfig {
    @Autowired
    @Qualifier("authDataSource")
    private DataSource dataSource;

    @Bean
    public Flyway db2Flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration/authdb")
                .load();
        flyway.migrate();
        return flyway;
    }
}
