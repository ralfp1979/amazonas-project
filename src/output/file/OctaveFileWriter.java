package output.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import output.DataCollector;

public class OctaveFileWriter {

	private File datafile;
	private File resultfile;
	private DataCollector data;
	private FileWriter dataWriter;
	private FileWriter resultOutput;

	public void setDataCollector(DataCollector data) {
		this.data = data;
	}

	public void writeFile(String name) {

		String filename = name + "_data.dat";
		datafile = createFile(filename);

		filename = name + "_result.dat";
		resultfile = createFile(filename);

		try {
			if (null != data) {
				writeDataToFiles();
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not write into file", e);
		}
	}

	private void writeDataToFiles() throws IOException {
		initFileWriter();

		int dataSize = data.getDataSize();

		List<String> myDataList = data.getData();
		List<String> myResultList = data.getResults();

		for (int ii = 0; ii < dataSize; ii++) {
			String myData = myDataList.get(ii);
			String myResult = myResultList.get(ii);

			writeSingleDataToFile(myData, myResult);
		}

		closeFileWriter();
	}

	private void closeFileWriter() throws IOException {
		dataWriter.flush();
		dataWriter.close();

		resultOutput.flush();
		resultOutput.close();
	}

	private void initFileWriter() throws IOException {
		dataWriter = new FileWriter(datafile, false);
		resultOutput = new FileWriter(resultfile, false);
	}

	private void writeSingleDataToFile(String myData, String myResult)
			throws IOException {
		dataWriter.write(myData);
		dataWriter.write(System.getProperty("line.separator"));

		resultOutput.write(myResult);
		resultOutput.write(System.getProperty("line.separator"));
	}

	private File createFile(String filename) {
		File file = new File(filename);
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException("Could not create file:" + filename, e);
		}

		return file;
	}
}
