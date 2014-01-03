package data;

import de.msiggi.sportsdata.webservices.Matchdata;

public class MatchResolver {

	public MatchResult getResult(Matchdata match) {

		int points1 = match.getPointsTeam1();
		int points2 = match.getPointsTeam2();

		if (points1 > points2) {
			return MatchResult.HOME;
		} else if (points1 < points2) {
			return MatchResult.AWAY;
		} else {
			return MatchResult.DEUCE;
		}
	}

}
