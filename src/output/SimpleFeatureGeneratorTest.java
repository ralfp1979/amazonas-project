package output;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;

public class SimpleFeatureGeneratorTest {

	private SimpleFeatureGenerator cut;

	@Before
	public void setUp() throws Exception {
		cut = new SimpleFeatureGenerator();
	}

	@Test
	public void testHomeWin() {
		ArrayOfTeam teams = SimpleDataCollectorTest.initTeams();

		ArrayOfMatchdata matches = SimpleDataCollectorTest
				.initMatches(teams, 1);
		Matchdata match = matches.getMatchdata().get(0);
		match.setPointsTeam1(2);
		match.setPointsTeam2(1);

		Standings standings = new Standings();
		standings.init(teams);
		standings.add(match);

		String features = cut.generate(match, standings);
		assertEquals("First against last", "1.0\t0.0", features);
	}

	@Test
	public void testAwayWin() {
		ArrayOfTeam teams = SimpleDataCollectorTest.initTeams();

		ArrayOfMatchdata matches = SimpleDataCollectorTest
				.initMatches(teams, 1);
		Matchdata match = matches.getMatchdata().get(0);
		match.setPointsTeam1(1);
		match.setPointsTeam2(2);

		Standings standings = new Standings();
		standings.init(teams);
		standings.add(match);

		String features = cut.generate(match, standings);
		assertEquals("First against last", "0.0\t1.0", features);
	}

}
