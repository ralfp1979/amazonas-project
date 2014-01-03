package output;

import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;

public interface DataCollector {

	public int getDataSize();

	public void addDatasets(ArrayOfMatchdata matches, Standings standings);

}
