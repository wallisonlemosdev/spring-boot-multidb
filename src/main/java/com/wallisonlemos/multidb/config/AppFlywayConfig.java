package com.wallisonlemos.multidb.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppFlywayConfig {
    @Autowired
    @Qualifier("appDataSource")
    private DataSource dataSource;

    @Bean
    public Flyway db1Flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration/appdb")
                .load();
        flyway.migrate();
        return flyway;
    }
}

