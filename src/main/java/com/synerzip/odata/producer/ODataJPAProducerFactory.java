package com.synerzip.odata.producer;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.ODataProducerFactory;
import org.odata4j.producer.jpa.JPAProducer;

public class ODataJPAProducerFactory implements ODataProducerFactory {

	private String persistenceUnitName = "odataJPAService";
	private String namespace = "odataJPA";
	private int maxResults = 50;

	@Override
	public ODataProducer create(Properties arg0) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);

		JPAProducer producer = new JPAProducer(emf, namespace, maxResults);

		return producer;
	}
}
