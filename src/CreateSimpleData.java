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
		SeasonSimulator season = new SeasonSimulator();
		season.setDataCollector(data);

		System.out.println("Season 2012...");
		data.setThreshold(4);
		season.simulate("bl1", "2012");

		System.out.println("Season 2011...");
		data.setThreshold(4);
		season.simulate("bl1", "2011");

		System.out.println("Season 2010...");
		data.setThreshold(4);
		season.simulate("bl1", "2010");

		System.out.println("Season 2009...");
		data.setThreshold(4);
		season.simulate("bl1", "2009");

		data.shuffle();
		return data;
	}

}
