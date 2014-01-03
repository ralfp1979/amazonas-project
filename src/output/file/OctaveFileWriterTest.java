package output.file;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import output.DataCollector;
import output.SeasonSimulator;
import output.SimpleDataCollector;

public class OctaveFileWriterTest {

	private static final String NAME_DATA_FILE = "name_data.dat";
	private static final String NAME_RESULT_FILE = "name_result.dat";
	private OctaveFileWriter cut;

	@Before
	public void setup() {
		DataCollector data = null;
		cut = new OctaveFileWriter();

		cut.setDataCollector(data);

		removeFilesIfExisting();
	}

	private void removeFilesIfExisting() {
		String filename = NAME_DATA_FILE;
		removeFileIfExisting(filename);
		filename = NAME_RESULT_FILE;
		removeFileIfExisting(filename);
	}

	private void removeFileIfExisting(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			file.delete();
		}
	}

	@Test
	public void testCreateFileData() {
		File file = new File(NAME_DATA_FILE);
		assertFalse(file.exists());

		cut.writeFile("name");

		assertTrue("File should be created", file.exists());
	}

	@Test
	public void testCreateFileResult() {
		File file = new File(NAME_RESULT_FILE);
		assertFalse(file.exists());

		cut.writeFile("name");

		assertTrue("File should be created", file.exists());
	}

	@Test
	public void testCheckReferenceFile() {
		DataCollector data = createReferenceData();

		cut.setDataCollector(data);
		cut.writeFile("check");

	}

	private DataCollector createReferenceData() {
		DataCollector data = new SimpleDataCollector();
		SeasonSimulator season = new SeasonSimulator();
		data.setThreshold(4);
		season.setDataCollector(data);
		season.simulate("bl1", "2012");
		return data;
	}

	@After
	public void tearDown() {
		removeFilesIfExisting();
	}

}
