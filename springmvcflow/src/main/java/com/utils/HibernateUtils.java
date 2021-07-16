package com.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.springmvcflow.model.Person;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/company");// ?useSSL=false
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				//settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				//settings.put(Environment.HBM2DML_AUTO, "create-drop");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(
						Person.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}