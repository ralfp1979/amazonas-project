package data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.Matchdata;

public class MatchResolverTest {

	private MatchResolver cut;

	@Before
	public void setUp() throws Exception {
		cut = new MatchResolver();
	}

	@Test
	public void testHomeWins() {
		Matchdata match = new Matchdata();
		match.setPointsTeam1(1);
		match.setPointsTeam2(0);

		assertEquals(MatchResult.HOME, cut.getResult(match));
	}

	@Test
	public void testDeuce() {
		Matchdata match = new Matchdata();
		match.setPointsTeam1(1);
		match.setPointsTeam2(1);

		assertEquals(MatchResult.DEUCE, cut.getResult(match));
	}

	@Test
	public void testAwayWins() {
		Matchdata match = new Matchdata();
		match.setPointsTeam1(1);
		match.setPointsTeam2(2);

		assertEquals(MatchResult.AWAY, cut.getResult(match));
	}

}
