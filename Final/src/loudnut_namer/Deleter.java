package loudnut_namer;

import java.io.File;

/**
 * This class provides a method to delete a specified String from filenames of a
 * batch of files.
 * 
 * @author 9722123 loudnut
 * 
 */
public class Deleter {

	/** 
	 * this string is to be deleted.
	 */
	public String unwantedString;

	/** 
	 * the word length of unwantedString.
	 */
	public int unwantedStringLength;

	/**
	 *  the input directory.
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
	 * Initializes all the fields from command-line arguments.<br/>
	 * The first element must be the destination directory, and the remaining
	 * will be taken as the unwanted string.<br/>
	 * <b>WARNING:</b> The Destination Directory Must Not Contain Whitespace!!
	 */
	public Deleter(String path, String unwantedString) {
		directory = new File(path);

		// check if input path is a directory
		if (directory.isDirectory()) {

			// setup file path
			filePath = directory.listFiles();

			// setup unwanted string (including spaces)
//			StringBuffer unwantedStringBuffer = new StringBuffer("");
			this.unwantedString = unwantedString;
			unwantedStringLength = unwantedString.length();
		} else{
			System.out.println("Error: Input is not a Directory\n\nPlease Check: Input Directory shall NOT contain whitespace.\n");
		}
	}

	/**
	 * performs the renaming operation.
	 */
	public void deleteUnwantedString() {
		for (int i = 0; i < filePath.length; i++) {

			// preparation for renaming using StringBuffer
			StringBuffer sb = new StringBuffer(filePath[i].toString());
			if (sb.lastIndexOf(unwantedString) != -1)
				sb.delete(sb.lastIndexOf(unwantedString),
						sb.lastIndexOf(unwantedString) + unwantedStringLength);

			// delete meaningless spaces
			if (sb.lastIndexOf(".") > 0
					&& sb.charAt(sb.lastIndexOf(".") - 1) == (char) 32) {
				sb.deleteCharAt(sb.lastIndexOf(".") - 1);
			}
			if (sb.lastIndexOf("\\") > 0
					&& sb.charAt(sb.lastIndexOf("\\") + 1) == (char) 32) {
				sb.deleteCharAt(sb.lastIndexOf("\\") + 1);
			}

			// rename the files (skipping hidden ones)
			if (!filePath[i].isHidden() && filePath[i].isFile())
				filePath[i].renameTo(new File(sb.toString()));
		}
//		System.out.println("done\n");
	}

	/**
	 * shows the delete task information.<br/>
	 * 1. input directory<br/>
	 * 2. unwanted String<br/>
	 */
	public void showTaskInfo() {
		System.out.println("Directory of " + directory);
		System.out.println("Unwanted Sting: " + unwantedString + "\n");
	}
}
