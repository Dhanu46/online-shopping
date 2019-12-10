package com.acharya.shoppingbackend.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.acharya.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private static StandardServiceRegistry standardServiceRegistry;
	  private static SessionFactory sessionFactory;

	  static{
		    if (sessionFactory == null) {
		      try {
		        // Create StandardServiceRegistry
		        standardServiceRegistry = new StandardServiceRegistryBuilder()
		            .configure()
		            .build();
		        // Create MetadataSources
		        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		        // Create Metadata
		        Metadata metadata = metadataSources.getMetadataBuilder().build();
		        // Create SessionFactory
		        sessionFactory = metadata.getSessionFactoryBuilder().build();
		      } catch (Exception e) {
		        e.printStackTrace();
		        if (standardServiceRegistry != null) {
		          StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
		        }
		      }
		    }
	  }
	  //Utility method to return SessionFactory
	  public static SessionFactory getSessionFactory() {
		  return sessionFactory;
	  }
	  
	  @Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

	  
	}
	
