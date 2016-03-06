package loudnut_namer;

import java.io.File;

/**
 * This class provides methods to list all files or directories of a specified
 * path.
 * 
 * @author 9722123 loudnut
 * 
 */
public class Viewer {

	/**
	 * the input directory.
	 */
	public File directory;

	/**
	 * an array of file names of the files under input directory.
	 */
	public String fileName[];

	/**
	 * an array of file path of the files under input directory.
	 */
	public File filePath[];

	/**
	 * Initializes all the fields from the first element of command-line
	 * arguments.<br/>
	 * <b>WARNING:</b> The first element shall be the Destination Directory and Must Not Contain Whitespace!!
	 */
	public Viewer(String dir) {
		directory = new File(dir);

		// check if input path is a directory
		if (directory.isDirectory()) {

			// setup file path
			filePath = directory.listFiles();

		} else {
			System.out
					.println("Error: Input is not a Directory\n\nPlease Check: Input Directory shall NOT contain whitespace.\n");
		}
	}

	/**
	 * lists the current files under input directory.
	 */
	public void showCurrentFilenames() {
		fileName = directory.list();
		for (int i = 0; i < fileName.length; i++)
			System.out.println(fileName[i]);
		System.out.print("\n");
	}

}
