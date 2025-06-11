package com.photon.lms.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.photon.lms.secondary.repository",
        entityManagerFactoryRef = "sqlserverEntityManager",
        transactionManagerRef = "sqlserverTransactionManager"
)
public class SqlServerDataSourceConfig {

    @Value("${sqlserver.datasource.url}")
    private String url;
    @Value("${sqlserver.datasource.driverClassName}")
    private String driverClassName;
    @Value("${sqlserver.datasource.username}")
    private String username;
    @Value("${sqlserver.datasource.password}")
    private String password;

    @Bean
    @ConfigurationProperties("sqlserver.datasource")
    public DataSource sqlserverDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .driverClassName(driverClassName)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean sqlserverEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("sqlserverDataSource") DataSource dataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none"); // Or 'update', 'create'
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect"); // Explicitly set dialect
        properties.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl"); // If needed

        return builder
                .dataSource(dataSource)
                .packages("com.photon.lms.secondary.entity")
                .persistenceUnit("sqlserverPU")
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager sqlserverTransactionManager(
            @Qualifier("sqlserverEntityManager") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
