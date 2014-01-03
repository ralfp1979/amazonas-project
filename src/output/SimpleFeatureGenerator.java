package output;

import data.Standings;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Team;

public class SimpleFeatureGenerator implements FeatureGenerator {

	@Override
	public String generate(Matchdata match, Standings standings) {

		Team home = new Team();
		home.setTeamID(match.getIdTeam1());

		Team away = new Team();
		away.setTeamID(match.getIdTeam2());

		float feature1 = generatePositionFeature(home, standings);
		float feature2 = generatePositionFeature(away, standings);

		String features = feature1 + "\t" + feature2;
		return features;
	}

	private float generatePositionFeature(Team team, Standings standings) {
		float numberOfTeams0Based = standings.getNumberOfTeams() - 1;
		float pos0Based = standings.getPositionOfTeam(team) - 1;

		float relativePos = pos0Based / numberOfTeams0Based;
		float feature = 1f - relativePos;

		int temp = (int) (feature * 100f);
		feature = temp / 100f;

		return feature;
	}
}
