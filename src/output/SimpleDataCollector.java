package output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.DataAndResultLine;
import data.MatchResolver;
import data.MatchResult;
import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.Matchdata;

public class SimpleDataCollector implements DataCollector {

	private final MatchResolver matchResolver = new MatchResolver();
	private int skipGroups = 0;
	private final List<DataAndResultLine> data = new ArrayList<DataAndResultLine>();

	private final FeatureGenerator featureGen = new SimpleFeatureGenerator();

	@Override
	public int getDataSize() {
		return data.size();
	}

	@Override
	public void addDatasets(ArrayOfMatchdata matches, Standings standings) {
		boolean shouldBeSkipped = skipGroups-- > 0;
		if (shouldBeSkipped) {
			return;
		}

		for (Matchdata match : matches.getMatchdata()) {
			saveData(match, standings);
		}
	}

	private void saveData(Matchdata match, Standings standings) {
		DataAndResultLine line = new DataAndResultLine();

		MatchResult result = matchResolver.getResult(match);
		line.setResult(result.getId());

		String features = featureGen.generate(match, standings);
		line.setData(features);

		data.add(line);
	}

	@Override
	public void setThreshold(int skippedGroups) {
		this.skipGroups = skippedGroups;
	}

	@Override
	public List<String> getResults() {
		List<String> results = new ArrayList<String>();

		for (DataAndResultLine line : data) {
			results.add(line.getResult());
		}

		return results;
	}

	@Override
	public List<String> getData() {
		List<String> results = new ArrayList<String>();

		for (DataAndResultLine line : data) {
			results.add(line.getData());
		}

		return results;
	}

	@Override
	public void shuffle() {
		Collections.shuffle(data);
	}

}
