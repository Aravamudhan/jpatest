package com.amudhan.jpatest.environment;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPASetup {

	protected final String persistenceUnitName;
	protected final Map<String, String> properties = new HashMap<>();
	protected EntityManagerFactory entityManagerFactory;

	public JPASetup(DatabaseProduct databaseProduct,
			String persistenceUnitName, String... hbmResources) {
		this.persistenceUnitName = persistenceUnitName;
		/*
		 * Check the possible settings and their in the
		 * org.hibernate.cfg.AvailableSettings
		 */
		properties.put("hibernate.archive.autodetection", "none");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.use_sql_comments", "true");
		properties.put("hibernate.dialect", databaseProduct.hibernateDialect);
		entityManagerFactory = Persistence.createEntityManagerFactory(
				getPersistenceUnitName(), properties);
	}

	public String getPersistenceUnitName() {
		return persistenceUnitName;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public EntityManager createEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}

	public void createSchema() {
		generateSchema("create");
	}

	public void dropSchema() {
		generateSchema("drop");
	}

	public void generateSchema(String action) {
		Map<String, String> createSchemaProperties = new HashMap<>(properties);
		createSchemaProperties.put(
				"javax.persistence.schema-generation.database.action", action);
		Persistence.generateSchema(getPersistenceUnitName(),
				createSchemaProperties);
	}

}
