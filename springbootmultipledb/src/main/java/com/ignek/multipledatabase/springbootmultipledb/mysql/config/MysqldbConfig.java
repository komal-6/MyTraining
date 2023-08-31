package com.ignek.multipledatabase.springbootmultipledb.mysql.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactoryBean",
		basePackages = {"com.ignek.multipledatabase.springbootmultipledb.mysql.repo"},
		transactionManagerRef = "transactionManager"
		)
public class MysqldbConfig {


	@Autowired
	private Environment environment;   //Fetching the properties file value
	
	//DataSource
	@Bean(name = "springdatasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.db1.datasource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("spring.db1.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("spring.db1.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("spring.db1.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.db1.datasource.password"));
		return dataSource;
	}
	
	
	
	//entityManagerFactory
	@Bean(name = "entityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(adapter);
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		em.setJpaPropertyMap(properties);
		em.setPackagesToScan("com.ignek.multipledatabase.springbootmultipledb.mysql.model");
		return em;
		
	}
	
	
	
	//platformTransactionManager
	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}
	 
}
