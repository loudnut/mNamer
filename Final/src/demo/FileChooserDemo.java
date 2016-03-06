package demo;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileChooserDemo extends JFrame {

	private JTextArea displayArea;
	private JScrollPane scrollPane;

	public FileChooserDemo() {
		super("Test");
		displayArea = new JTextArea();
		scrollPane = new JScrollPane(displayArea);

		add(scrollPane, BorderLayout.CENTER);
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private File selectFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		
		if(result==JFileChooser.CANCEL_OPTION)
			System.exit(1);
		File fileName = fileChooser.getSelectedFile();
		return fileName;
	}
	
	public static void main(String args[]){
		FileChooserDemo info = new FileChooserDemo();
		System.out.println(info.selectFile());
	}
}
