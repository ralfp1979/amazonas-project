package data;

import de.msiggi.sportsdata.webservices.ArrayOfTeam;

public class Standings {

	private final ArrayOfTeam teams = new ArrayOfTeam();

	public int getNumberOfTeams() {
		return this.teams.getTeam().size();
	}

	public void init(ArrayOfTeam teams) {
		this.teams.getTeam().addAll(teams.getTeam());
	}

}
