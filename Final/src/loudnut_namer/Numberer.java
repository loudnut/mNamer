package loudnut_namer;

import java.io.File;

/**
 * This Main class reuses Viewer and Namer class in previous solutions, and
 * provides a main function that </br> changes the names of all files that are
 * of the type .mp3 in a certain folder</br> to numbered names from 1.mp3 to
 * x.mp3, where x is the number of .mp3 files in the folder.
 * 
 * 
 * @author 9722123 loudnut
 * 
 */

public class Numberer {

	public void numbering(String path, String numberingString) {

		Viewer v = new Viewer(path);
		String[] fileName = v.directory.list();
		String[] newName = new String[fileName.length];
		String commonToken = numberingString;
		Integer namingNumber = 1;

		int total = fileName.length;
		int maxDigit = fileName.length == 0 ? 0 : 1;
		while ((total /= 10) > 0)
			maxDigit++;

		System.out.println(fileName.length);
		System.out.println(maxDigit);
		System.out.println("%0" + maxDigit + "d");

		for (int i = 0; i < fileName.length; i++) {

//			System.out.println(path + "\\" + fileName[i].toString() + " " + new File(path + "\\" + fileName[i].toString()).isDirectory());
			if (new File(path + "\\" + fileName[i].toString()).isDirectory())
				continue;
			
			
			// if (fileName[i].indexOf(".mp3") > 0) {
			newName[i] = commonToken
					+ String.format("%0" + maxDigit + "d",
							Integer.parseInt(namingNumber.toString()))
					+ fileName[i].substring(fileName[i].lastIndexOf('.'));
			namingNumber++;
			// } else
			// newName[i] = fileName[i];
		}

		Namer n = new Namer(v.directory, v.filePath, newName);
		n.name();

		// System.out.println("OK");
	}
}
