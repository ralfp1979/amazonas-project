package output;

import data.Standings;
import de.msiggi.sportsdata.webservices.Matchdata;

public interface FeatureGenerator {

	String generate(Matchdata match, Standings standings);

}
