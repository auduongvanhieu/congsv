package com.cce.vietnguyen.config;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Configuration
public class AppConfig {
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}
	@Bean
	public Module datatypeHibernateModule() {
		  Hibernate4Module hibernate4Module = new Hibernate4Module();
		  hibernate4Module.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, false);
		  hibernate4Module.configure(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true);
		  hibernate4Module.disable(Feature.USE_TRANSIENT_ANNOTATION);
		  return hibernate4Module;
	}
	
}