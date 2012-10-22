package com.synerzip.odata.consumer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.consumer.ODataConsumers;
import org.odata4j.core.OEntity;
import org.odata4j.core.OFuncs;
import org.odata4j.core.OProperties;
import org.odata4j.exceptions.NotFoundException;

public class ODataTestServiceReadWriteExample extends AbstractExample {

	public final static String LINE_DELIMITER = "-------------------------------------------------------";
	private final static String ODATA_TEST_ENDPOINT = "http://localhost:8080/odata_example/odatajpa.svc/";
	ODataConsumer consumer = null;

	@Before
	public void setup() {
		this.consumer = ODataConsumers.create(ODATA_TEST_ENDPOINT);
	}

	@After
	public void teardown() {
		this.consumer = null;
	}

	/**
	 * Test get operations for odata
	 */
	@Test
	public void testGetOperations() {

		// take a look at the service edm
		reportMetadata(consumer.getMetadata());
		report(LINE_DELIMITER);

		// retrieve a supplier entity with a known id
		OEntity supplier = consumer.getEntity("Supplier", "S101").execute();
		reportEntity("Supplier S101", supplier);
		report(LINE_DELIMITER);

		// list all parts
		for (OEntity product : consumer.getEntities("Parts").execute()) {
			reportEntity(
					"Parts: " + product.getProperty("partName").getValue(),
					product);
		}
		report(LINE_DELIMITER);

		// query for the part by color to get the first color
		OEntity greenParts = consumer.getEntities("Parts")
				.filter("partColor eq 'Green'").top(1).execute().first();
		reportEntity("Green Parts", greenParts);
		report(LINE_DELIMITER);

		// Query for the highest-rated product
		report("highest named supplier (compute on server): "
				+ consumer.getEntities("Supplier").orderBy("supplierName desc")
						.top(1).execute().first());
		report("highest named supplier (compute on client): "
				+ consumer
						.getEntities("Supplier")
						.execute()
						.orderBy(
								OFuncs.entityPropertyValue("supplierName",
										String.class)).last());
		report(LINE_DELIMITER);

	}

	/**
	 * Test save a new entity, update it and then delete it
	 */
	@Test
	public void testSaveAndDelete() {
		/*
		 * This is failing now for create/merge/update in case you are using
		 * getter/setter based JPA mapping. It only works if you are using field
		 * level JPA mapping.
		 */
		// we are about to add a new Supplier, first make sure it does not
		// exist by deleting existing supplier
		try {
			consumer.deleteEntity("Supplier", "S200").execute();
		} catch (NotFoundException notFoundException) {
			report(notFoundException.getMessage());
			report(LINE_DELIMITER);
		}

		// create the new product
		OEntity newSupplier = consumer.createEntity("Supplier")
				.properties(OProperties.string("supplierId", "S200"))
				.properties(OProperties.string("supplierName", "Smith A"))
				.properties(OProperties.string("supplierCity", "Boston"))
				.properties(OProperties.string("supplierState", "MA"))
				.properties(OProperties.decimal("supplierStatus", 20L))
				.execute();
		report("newSupplier: " + newSupplier);
		report(LINE_DELIMITER);

		// update the newly created product
		consumer.updateEntity(newSupplier)
				.properties(OProperties.string("supplierName", "Carl A"))
				.execute();

		report("newSupplier name after update: "
				+ consumer.getEntity("Supplier", "S200").execute()
						.getProperty("supplierName").getValue());
		report(LINE_DELIMITER);

		// update the newly create product using merge
		consumer.mergeEntity("Supplier", "S101")
				.properties(OProperties.string("supplierName", "Zack A"))
				.execute();

		report("newPart rating after merge: "
				+ consumer.getEntity("Supplier", "S101").execute()
						.getProperty("supplierName").getValue());
		report(LINE_DELIMITER);

		// clean up, delete the new product
		consumer.deleteEntity("Supplier", "S200").execute();

		try {
			consumer.getEntity("Supplier", "S200").execute();
			report("New supplier was not deleted");
		} catch (NotFoundException notFoundException) {
			report("New supplier deleted!");
		}
	}
}
