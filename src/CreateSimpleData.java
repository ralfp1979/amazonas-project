import output.DataCollector;
import output.SeasonSimulator;
import output.SimpleDataCollector;
import output.file.OctaveFileWriter;

public class CreateSimpleData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateSimpleData main = new CreateSimpleData();
		main.createFile();
	}

	private void createFile() {
		DataCollector data = createReferenceData();

		OctaveFileWriter cut = new OctaveFileWriter();
		cut.setDataCollector(data);
		cut.writeFile("simple");

	}

	private DataCollector createReferenceData() {
		DataCollector data = new SimpleDataCollector();
		SeasonSimulator simulator = new SeasonSimulator();
		simulator.setDataCollector(data);

		for (int ii = 2006; ii <= 2012; ii++) {
			addSeason(data, simulator, ii);
		}

		data.shuffle();
		return data;
	}

	private void addSeason(DataCollector data, SeasonSimulator simulator,
			int season) {
		String date = String.valueOf(season);
		System.out.println("Season " + date + "...");

		data.setThreshold(4);
		simulator.simulate("bl1", date);

		data.setThreshold(4);
		simulator.simulate("bl2", date);
	}

}
