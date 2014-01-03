package output;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.Team;

public class SeasonSimulatorTest {

	private SeasonSimulator cut;

	@Before
	public void setUp() throws Exception {
		cut = new SeasonSimulator();
	}

	@Test
	public void testSimulate() {
		cut.simulate("bl1", "2011");
		Team winner = cut.getWinner();

		assertEquals("Dortmund has won", 7, winner.getTeamID());
	}

	@Test
	public void testDataCollectorCallback() {

		DataCollector collector = new SimpleDataCollector();
		cut.setDataCollector(collector);
		cut.simulate("bl1", "2011");

		assertEquals(34 * 9, collector.getDataSize());
	}

}
