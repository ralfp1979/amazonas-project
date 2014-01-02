package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.Team;

public class TeamResultTest {

	private Team teamA;
	private Team teamB;
	private TeamResult resultA;
	private TeamResult resultB;

	@Before
	public void setUp() throws Exception {
		teamA = StandingsTest.createTeam(1, "A");
		teamB = StandingsTest.createTeam(2, "B");

		resultA = new TeamResult(teamA);
		resultB = new TeamResult(teamB);
	}

	@Test
	public void testEqual() {
		resultA.addPoints(1);
		resultB.addPoints(1);

		assertEquals(0, resultA.compareTo(resultB));
	}

	@Test
	public void testMorePoints() {
		resultA.addPoints(3);
		resultB.addPoints(1);

		assertEquals(-1, resultA.compareTo(resultB));
	}

	@Test
	public void testLessPonts() {
		resultA.addPoints(0);
		resultB.addPoints(2);

		assertEquals(1, resultA.compareTo(resultB));
	}

	@Test
	public void testTeamEqualsTeamResult() throws Exception {
		assertTrue(resultA.equals(teamA));
		assertFalse(resultB.equals(teamA));
	}
}
