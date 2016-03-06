package loudnut_namer;

import java.io.File;

/**
 * This class provides a method to replace a specified String from filenames of a
 * batch of files.
 * 
 * @author 9722123 loudnut
 * 
 */
public class Replacer {

	/** 
	 * this string is to be replaced.
	 */
	public String replacedString;

	/** 
	 * this string is to replace the other string.
	 */
	public String replacingString;
	
	/** 
	 * the word length of replacedString.
	 */
	public int replacedStringLength;

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
	public Replacer(String path, String replacedString, String replacingString) {
		directory = new File(path);

		// check if input path is a directory
		if (directory.isDirectory()) {

			// setup file path
			filePath = directory.listFiles();
			fileName = directory.list();

			// setup unwanted string (including spaces)
//			StringBuffer replacedStringBuffer = new StringBuffer("");
			this.replacedString = replacedString;
			replacedStringLength = replacedString.length();
			this.replacingString = replacingString;
		} else{
			System.out.println("Error: Input is not a Directory\n\nPlease Check: Input Directory shall NOT contain whitespace.\n");
		}
	}

	/**
	 * performs the renaming operation.
	 */
	public void stringReplacementFirst() {
		for (int i = 0; i < filePath.length; i++) {

			// preparation for renaming using StringBuffer
			StringBuffer sb = new StringBuffer(fileName[i].toString());
			if (sb.indexOf(replacedString) != -1)
				sb.replace(sb.indexOf(replacedString),
						sb.indexOf(replacedString) + replacedStringLength, replacingString);

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
				filePath[i].renameTo(new File(directory + "\\" + sb.toString()));
		}
	}
	
	public void stringReplacementLast() {
		for (int i = 0; i < filePath.length; i++) {

			// preparation for renaming using StringBuffer
			StringBuffer sb = new StringBuffer(filePath[i].toString());
			if (sb.lastIndexOf(replacedString) != -1)
				sb.replace(sb.lastIndexOf(replacedString),
						sb.lastIndexOf(replacedString) + replacedStringLength, replacingString);

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
	}
	
	public void stringReplacementAll() {
		for (int i = 0; i < filePath.length; i++) {

			// preparation for renaming using StringBuffer
			String str = fileName[i].toString();
			// rename the files (skipping hidden ones)
			if (!filePath[i].isHidden() && filePath[i].isFile())
				filePath[i].renameTo(new File(directory + "\\" + str.replaceAll(replacedString, replacingString)));
		}
	}

	/**
	 * shows the delete task information.<br/>
	 * 1. input directory<br/>
	 * 2. unwanted String<br/>
	 */
	public void showTaskInfo() {
		System.out.println("Directory of " + directory);
		System.out.println("Unwanted Sting: " + replacedString + "\n");
	}
}
