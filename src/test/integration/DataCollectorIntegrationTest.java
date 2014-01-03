package test.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import output.DataCollector;
import output.SeasonSimulator;
import output.SimpleDataCollector;

public class DataCollectorIntegrationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCollectFromSeveralSeasons() {
		DataCollector collect = new SimpleDataCollector();

		SeasonSimulator soccer = new SeasonSimulator();
		soccer.setDataCollector(collect);

		collect.setThreshold(30);
		soccer.simulate("bl1", "2012");

		collect.setThreshold(20);
		soccer.simulate("bl1", "2011");

		int expectedCount = (4 + 14) * 9;
		assertEquals("Results from both seasons", expectedCount, collect
				.getResults().size());
		assertEquals("Data from both seasons", expectedCount, collect.getData()
				.size());
	}
}
