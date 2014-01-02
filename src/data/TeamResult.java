package data;

import de.msiggi.sportsdata.webservices.Team;

public class TeamResult implements Comparable<TeamResult> {

	private int points = 0;
	private final Team team;

	public TeamResult(Team team) {
		this.team = team;
	}

	@Override
	public int compareTo(TeamResult opponent) {

		// more points means earlier in the standing
		return -1 * new Integer(points).compareTo(opponent.points);
	}

	public void addPoints(int p) {
		points += p;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Team) {
			Team team = (Team) obj;
			return this.team.getTeamID() == team.getTeamID();
		} else if (obj instanceof TeamResult) {
			TeamResult result = (TeamResult) obj;
			return this.equals(result.team);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.team.getTeamID() * this.team.getTeamName().hashCode();
	}

	public Team getTeam() {
		return this.team;
	}

}
