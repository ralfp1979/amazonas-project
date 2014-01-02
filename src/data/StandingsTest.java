package data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Team;

public class StandingsTest {

	private Standings cut;

	@Before
	public void setUp() throws Exception {
		cut = new Standings();
	}

	@Test
	public void testInit() {
		ArrayOfTeam teams = new ArrayOfTeam();
		teams.getTeam().add(new Team());
		teams.getTeam().add(new Team());

		assertEquals(0, cut.getNumberOfTeams());
		cut.init(teams);

		assertEquals(teams.getTeam().size(), cut.getNumberOfTeams());

	}
}
