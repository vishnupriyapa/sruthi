package com.controller;


	import java.util.Properties;

	import javax.sql.DataSource;

	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

	@Configuration
	public class DBConfiguration {
	                @Value("${db.driver}")
	                private String driver;
	                @Value("${db.url}")
	                private String url;
	                @Value("${db.username}")
	                private String username;
	                @Value("${db.password}")
	                private String password;
	                @Value("${hibernate.dialect}")
	                private String dialect;
	                @Value("${hibernate.show_sql}")
	                private String show_sql;
	                @Value("${hibernate.hbm2ddl.auto}")
	                private String hbm2ddl;
	                @Value("${packages_to_scan}")
	                private String packages;
	                @Bean
	               
	                public DriverManagerDataSource dataSource(){
	                	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	                	 dataSource.setDriverClassName(driver);
	                	    dataSource.setUrl(url);
	                	    dataSource.setUsername(username);
	                	    dataSource.setPassword(password);
	                	    return dataSource;

	                	
	                }
	                @Bean
	                public LocalSessionFactoryBean sessionFactory()
	                {
	                                LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
	                                sf.setDataSource(dataSource());
	                                sf.setPackagesToScan(packages);
	                                Properties p=new Properties();
	                                p.put("hibernate.dialect", dialect);
	                                p.put("hibernate.show_sql", show_sql);
	                                p.put("hibernate.hbm2ddl.auto",hbm2ddl );
	                                sf.setHibernateProperties(p);
	                                return sf;
	                }
	                @Bean
	                public HibernateTransactionManager transactionManager()
	                {
	                                HibernateTransactionManager htm=new HibernateTransactionManager();
	                                htm.setSessionFactory(sessionFactory().getObject());
	                                return htm;
	                }
	}


