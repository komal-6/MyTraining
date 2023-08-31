package com.ignek.multipledatabase.springbootmultipledb.postgres.config;

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
		entityManagerFactoryRef = "secondEntityManagerFactoryBean",
		basePackages = {"com.ignek.multipledatabase.springbootmultipledb.postgres.repo"},
		transactionManagerRef = "secondTransactionManager"
		)
public class PostgresqlConfig {

	@Autowired
	private Environment environment; //Fetching the properties file value
	
	//DataSource
	@Bean(name = "springseconddatasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.db2.datasource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("spring.db2.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("spring.db2.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("spring.db2.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.db2.datasource.password"));
		return dataSource;
	}
	
	
	
	//entityManagerFactory
	@Bean(name = "secondEntityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(adapter);
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		em.setJpaPropertyMap(properties);
		em.setPackagesToScan("com.ignek.multipledatabase.springbootmultipledb.postgres.model");
		return em;
		
	}
	
	
	//platformTransactionManager
	@Bean(name = "secondTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}

}
