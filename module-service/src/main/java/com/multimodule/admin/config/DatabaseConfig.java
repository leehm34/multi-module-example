//package com.multimodule.project1.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.multimodule.project1.repository", // pa repository 패키지 경로
//        entityManagerFactoryRef = "entityManager",
//        transactionManagerRef = "transactionManager"
//)
//@Slf4j
//public class DatabaseConfig {
//    @Primary
//    @Bean
//    public LocalContainerEntityManagerFactoryBean paEntityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(paDataSource());
//        em.setPackagesToScan("com.crossangle.pa.core.entity.pa");
//        em.setPersistenceUnitName("paEntityManager");
//
//        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(va);
//
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "none");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.setProperty("hibernate.format_sql", "true");
//        properties.setProperty("hibernate.use_sql_comments", "true");
//
//        em.setJpaProperties(properties);
//        return em;
//    }
//
//    @Primary
//    @Bean("paDataSource")
//    public DataSource paDataSource() {
//        return new HikariDataSource(paHikariConfig());
//    }
//
//    @Primary
//    @Bean(name="jdbcPa")
//    public JdbcTemplate paJdbcTemplate(@Qualifier("paDataSource") DataSource paDataSource) {
//        return new JdbcTemplate(paDataSource);
//    }
//
//    @Primary
//    @Bean(name="namedJdbcPa")
//    public NamedParameterJdbcTemplate paNamedParameterJdbcTemplate(@Qualifier("paDataSource") DataSource paDataSource) {
//        return new NamedParameterJdbcTemplate(paDataSource);
//    }
//
//    @Primary
//    @Bean("paHikariConfig")
//    @ConfigurationProperties(prefix = "spring.datasource.pa.hikari")
//    public HikariConfig paHikariConfig() {
//        return new HikariConfig();
//    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager paTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(paEntityManager().getObject());
//
//        return transactionManager;
//    }
//
//    @Primary
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor paExceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//}
