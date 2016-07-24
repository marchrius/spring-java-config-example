package com.hms.pro.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({"classpath:globels.properties"})
public class DataSourceConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public DriverManagerDataSource dataSource(){
		//You can use C3po connection pool here for better performance to the application
		System.out.println("JDBC USERNAME :"+environment.getProperty("jdbc.username")+" password :"+environment.getProperty("jdbc.password"));
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName").trim());
	    dataSource.setUrl(environment.getProperty("jdbc.url").trim());
	    dataSource.setUsername(environment.getProperty("jdbc.username").trim());
	    dataSource.setPassword(environment.getProperty("jdbc.password").trim());
	    return dataSource;
	}
	
}
