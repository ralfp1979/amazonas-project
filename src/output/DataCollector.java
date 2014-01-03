package output;

import java.util.List;

import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;

public interface DataCollector {

	public int getDataSize();

	public void addDatasets(ArrayOfMatchdata matches, Standings standings);

	public void setThreshold(int skippedGroups);

	public List<String> getResults();

	public List<String> getData();

	public void shuffle();

}
