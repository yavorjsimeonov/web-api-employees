package com.web.api.employees.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//@Configuration
public class DatabaseConfiguration {
//  @Bean(name = "appDataSource")
//  @Primary
//  @ConfigurationProperties(prefix = "spring.datasource")
//  public DataSource dataSource() {
//    return DataSourceBuilder.create().build();
//  }
//
//  @Bean(name = "applicationJdbcTemplate")
//  public JdbcTemplate applicationDataConnection(){
//    return new JdbcTemplate(dataSource());
//  }
}
