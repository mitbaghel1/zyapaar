package com.zpdemo.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;

@Configuration
public class DbConfiguration {

	@Bean(name = "post")
	public DataSource postgreDatasource()
	{
		DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://127.0.0.1:5432/ImageTestDb");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("3872");
		
		HikariConfig config = new HikariConfig();
		config.setMaximumPoolSize(3000);
        config.setConnectionTimeout(300000);
        config.setConnectionTimeout(120000);
        config.setLeakDetectionThreshold(300000);
        return dataSourceBuilder.build();
	}
}
