package com.ikpb.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static SessionFactory sf;
	
	private static SessionFactoryUtil sfu;
	
	private static final String USERNAME = System.getenv("POSTGRES_USERNAME");
	private static final String PASSWORD = System.getenv("AWS_POSTGRES_PASSWORD");
	private static final String URL = "jdbc:postgresql://"+ System.getenv("AWS_POSTGRES_URL")+":5432/superhuman?";
	private static String schema = "public";
	
	public static SessionFactoryUtil getSessionFactoryUtil() {
		if (sfu == null) {
			sfu = new SessionFactoryUtil();
		}
		return sfu;
	}
	private SessionFactoryUtil() {
		if (sf== null) {
			Map<String, String> settings = new HashMap<String, String>();
			settings.put("hibernate.connection.driver_class","org.postgresql.Driver");
			settings.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.default_schema",schema);
			settings.put("connection.pool_size", "1");
			settings.put("hibernate.connection.url", URL);
			settings.put("hibernate.connection.username", USERNAME);
			settings.put("hibernate.connection.password", PASSWORD);
			
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.addAnnotatedClass(com.ikpb.domain.SuperHuman.class)
					.addAnnotatedClass(com.ikpb.domain.SuperTeam.class)
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
					.build();
			sf = metadata.getSessionFactoryBuilder().build();
			
		}
	}
	public SessionFactory getSessionFactory() {
		return this.sf;
	}

}
