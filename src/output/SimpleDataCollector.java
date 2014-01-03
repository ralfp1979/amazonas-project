package output;

import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.Matchdata;

public class SimpleDataCollector implements DataCollector {

	private int count = 0;

	@Override
	public int getDataSize() {
		return count;
	}

	@Override
	public void addDatasets(ArrayOfMatchdata matches, Standings standings) {
		for (Matchdata match : matches.getMatchdata()) {
			count++;
		}
	}

}
