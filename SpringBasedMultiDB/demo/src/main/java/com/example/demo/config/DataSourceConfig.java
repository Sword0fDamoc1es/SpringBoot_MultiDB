package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig{

    @Bean
    @ConfigurationProperties(prefix = "primary.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties(prefix = "secondary.datasource")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }
}