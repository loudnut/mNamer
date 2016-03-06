package loudnut_namer;

/**
 * This class provides methods to modify especially the <b>cases</b> of
 * filenames in the input directory.
 * 
 * @author 9722123 loudnut
 * 
 */
public class CaseOperator {

	/**
	 * The input directory.
	 */
	public String directory;

	public CaseOperator(String inputPath) {
		directory = inputPath;
	}

	/**
	 * This method turns all the filenames in the input directory into
	 * CamelCase.</br> So far the word separator is considered only the
	 * space.</br> PS. This method reuses Viewer(from 9722123) and Namer(from
	 * 9722105).
	 */
	public void toCamelCase() {
		Viewer v = new Viewer(directory);
		String[] fileName = v.directory.list();
		String[] newName = new String[fileName.length];

		for (int k = 0; k < fileName.length; k++) {
			StringBuffer sb = new StringBuffer(fileName[k].toLowerCase());
			for (int i = 0; i < sb.length(); i++) {
				if (i == 0)
					sb.replace(i, i + 1, sb.substring(i, i + 1).toUpperCase());
				if (sb.charAt(i) == 32)
					sb.replace(i + 1, i + 2, sb.substring(i + 1, i + 2)
							.toUpperCase());
			}
			newName[k] = sb.toString();
		}

		Namer n = new Namer(v.directory, v.filePath, newName);
		n.name();
	}

	/**
	 * This method turns all the filenames in the input directory into
	 * UpperCase.
	 */
	public void toUpperCase() {
		Viewer v = new Viewer(directory);
		String[] fileName = v.directory.list();
		String[] newName = new String[fileName.length];

		for (int k = 0; k < fileName.length; k++) {
			StringBuffer sb = new StringBuffer(fileName[k].toUpperCase());
			newName[k] = sb.toString();
		}

		Namer n = new Namer(v.directory, v.filePath, newName);
		n.name();
	}

	/**
	 * This method turns all the filenames in the input directory into
	 * LowerCase.
	 */
	public void toLowerCase() {
		Viewer v = new Viewer(directory);
		String[] fileName = v.directory.list();
		String[] newName = new String[fileName.length];

		for (int k = 0; k < fileName.length; k++) {
			StringBuffer sb = new StringBuffer(fileName[k].toLowerCase());
			newName[k] = sb.toString();
		}

		Namer n = new Namer(v.directory, v.filePath, newName);
		n.name();
	}
}