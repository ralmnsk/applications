package web4.hibernate.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
@EnableTransactionManagement
@ComponentScan({"web4.hibernate.config"})
@PropertySource(value= {"classpath:application.properties"})
public class HibernateConfiguration {
	
	private static Logger logger =
			LoggerFactory.getLogger(HibernateConfiguration.class);
			
	@Autowired
	private Environment environment;
	
	@Bean
	public SessionFactory sessionFactory() { 
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(new String[] {"web4.model"});
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		
		return sessionFactoryBean.getObject();
	}
	
	
	@Bean
	public DataSource dataSource() {
		try {
				EmbeddedDatabaseBuilder dbBuilder =
				new EmbeddedDatabaseBuilder();
				return dbBuilder.setType(EmbeddedDatabaseType.H2)
				.addScripts("classpath:sql/schema.sql",
				"classpath:sql/data.sql").build();
			} catch (Exception e) {
				logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
			}
	}
	
	
	private Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		
		return hibernateProp;
	}
	
	
	@Bean 
	public PlatformTransactionManager transactionManager()
			throws IOException {
			return new HibernateTransactionManager(sessionFactory());
			}

}
