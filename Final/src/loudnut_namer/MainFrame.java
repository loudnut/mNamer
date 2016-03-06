package loudnut_namer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame implements ActionListener {

	JTextField pathDisplay = new JTextField("請選擇資料夾路徑", 40);
	File subjectPath;
	String specifiedString;

	JTextField inputString = new JTextField("請輸入想要加入或刪除的字串", 40);
	JButton btnStringOperation = new JButton("開始");
	JRadioButton btnAddString = new JRadioButton("增加此字串");
	JRadioButton btnDelString = new JRadioButton("刪除此字串", true);

	JCheckBox numberingStringCheckBox = new JCheckBox("加入以下字串");
	JTextField numberingString = new JTextField("請輸入編號前想要加入的字串", 20);
	JCheckBox numberingStringSaftyCheckBox = new JCheckBox("我知道這會把原本檔名通通洗掉");
	JButton btnNumberingOperation = new JButton("開始");

	JRadioButton btnToUpperCase = new JRadioButton("全轉大寫");
	JRadioButton btnToLowerCase = new JRadioButton("全轉小寫");
	JRadioButton btnToCamelCase = new JRadioButton("首字母大寫其餘小寫", true);
	JButton btnCaseOperation = new JButton("開始");

	JTextField replacedString = new JTextField("目標字串", 40);
	JTextField replacingString = new JTextField("取代為...", 40);
	JRadioButton btnReplaceOnFirst = new JRadioButton("作用於最前");
	JRadioButton btnReplaceOnLast = new JRadioButton("作用於最後");
	JRadioButton btnReplaceAll = new JRadioButton("作用於全部");
	JButton btnReplacingStringOperation = new JButton("開始");

	// JCheckBox renamingStringCheckBox = new JCheckBox("加入以下字串");
	// JCheckBox renamingStringSaftyCheckBox = new JCheckBox("我知道這會把原本檔名通通洗掉");
	// JTextField renamingString = new JTextField("請輸入編號前想要加入的字串", 20);
	// JButton btnRenamingOperation = new JButton("開始");

	public MainFrame() {
		super("loudnut Namer v.21");
		System.out
				.println("v.21 : Numbering tab is not limited to *.mp3 anymore");

		pathDisplay.setEditable(false);

		JButton btnChoosePath = new JButton("選擇路徑");

		btnChoosePath.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				subjectPath = choosePath();
				if (subjectPath != null)
					pathDisplay.setText(subjectPath.toString());
			}
		});

		JTabbedPane tabbedPane = new JTabbedPane();
		//
		//
		//
		//
		//
		//
		// set up String-handling panel and add it to JTabbedPane
		JLabel label1 = new JLabel("在檔名中刪除或在開頭加入指定字串", SwingConstants.CENTER);
		JPanel panelString = new JPanel();
		JPanel panelStringIn1 = new JPanel();
		panelString.setLayout(new GridLayout(0, 1));
		panelString.add(label1, BorderLayout.NORTH);
		panelString.add(panelStringIn1, BorderLayout.WEST);

		tabbedPane.addTab("增刪字串", null, panelString);

		panelStringIn1.setLayout(new FlowLayout());

		// JTextField inputString = new JTextField("請輸入想要加入或刪除的字串", 40);
		panelString.add(inputString);

		// JRadioButton btnAddString = new JRadioButton("增加此字串");
		panelString.add(btnAddString);
		// JRadioButton btnDelString = new JRadioButton("刪除此字串", true);
		panelString.add(btnDelString);
		ButtonGroup groupString = new ButtonGroup();
		groupString.add(btnAddString);
		groupString.add(btnDelString);

		// JButton btnStringOperation = new JButton("開始");
		panelString.add(btnStringOperation);
		btnStringOperation.addActionListener(this);
		//
		//
		//
		//
		//
		//
		// set up panelNumbering and add it to JTabbedPane
		JLabel label2 = new JLabel("在檔名開頭加上編號", SwingConstants.CENTER);
		JPanel panelNumbering = new JPanel();
		JPanel panelNumberingIn1 = new JPanel();

		panelNumbering.setLayout(new GridLayout(0, 1));
		panelNumbering.add(label2, BorderLayout.NORTH);
		panelNumbering.add(panelNumberingIn1, BorderLayout.WEST);

		tabbedPane.addTab("上編號", null, panelNumbering);

		panelNumberingIn1.setLayout(new FlowLayout());

		panelNumbering.add(numberingStringSaftyCheckBox);
		panelNumbering.add(numberingStringCheckBox);
		panelNumbering.add(numberingString);

		panelNumbering.add(btnNumberingOperation);
		
		btnNumberingOperation.setEnabled(false);
		numberingStringSaftyCheckBox.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (numberingStringSaftyCheckBox.isSelected())
					btnNumberingOperation.setEnabled(true);
				else
					btnNumberingOperation.setEnabled(false);
			}
		});

		// btnNumberingOperation.setEnabled(numberingStringSaftyCheckBox.isSelected());
		btnNumberingOperation.addActionListener(this);

		//
		//
		//
		//
		//
		//
		// set up panelCaseSwitch and add it to JTabbedPane
		JLabel label3 = new JLabel("轉換檔名大小寫", SwingConstants.CENTER);
		JPanel panelCaseSwitch = new JPanel();

		panelCaseSwitch.setLayout(new GridLayout(0, 1));
		panelCaseSwitch.add(label3, BorderLayout.NORTH);

		tabbedPane.addTab("大小寫切換", null, panelCaseSwitch);

		panelCaseSwitch.add(btnToUpperCase);
		panelCaseSwitch.add(btnToLowerCase);
		panelCaseSwitch.add(btnToCamelCase);

		ButtonGroup groupCase = new ButtonGroup();
		groupCase.add(btnToUpperCase);
		groupCase.add(btnToLowerCase);
		groupCase.add(btnToCamelCase);

		panelCaseSwitch.add(btnCaseOperation);
		btnCaseOperation.addActionListener(this);

		//
		//
		//
		//
		//
		//
		// set up panelStringReplacement and add it to JTabbedPane
		JLabel label4 = new JLabel("將特定字串取代為指定字串", SwingConstants.CENTER);
		JPanel panelStringReplacement = new JPanel();

		panelStringReplacement.setLayout(new GridLayout(0, 1));
		panelStringReplacement.add(label4, BorderLayout.NORTH);

		tabbedPane.addTab("取代字串", null, panelStringReplacement);

		panelStringReplacement.add(replacedString);
		panelStringReplacement.add(replacingString);

		panelStringReplacement.add(btnReplaceOnFirst);
		panelStringReplacement.add(btnReplaceOnLast);
		panelStringReplacement.add(btnReplaceAll);

		ButtonGroup groupReplace = new ButtonGroup();
		groupReplace.add(btnReplaceOnFirst);
		groupReplace.add(btnReplaceOnLast);
		groupReplace.add(btnReplaceAll);

		panelStringReplacement.add(btnReplacingStringOperation);
		btnReplacingStringOperation.addActionListener(this);
		//
		//
		//
		//
		//
		//
		// set up panelRenaming and add it to JTabbedPane
		// JLabel label5 = new JLabel("完全自訂檔名與編號", SwingConstants.CENTER);
		// JPanel panelRenaming = new JPanel();
		// JPanel panelRenamingIn1 = new JPanel();
		//
		// panelRenaming.setLayout(new GridLayout(0, 1));
		// panelRenaming.add(label5, BorderLayout.NORTH);
		// panelRenaming.add(panelRenamingIn1, BorderLayout.WEST);
		//
		// tabbedPane.addTab("自訂檔名", null, panelRenaming);
		//
		// panelRenamingIn1.setLayout(new FlowLayout());
		//
		// panelRenaming.add(renamingStringCheckBox);
		// panelRenaming.add(renamingStringSaftyCheckBox);
		// panelRenaming.add(renamingString);
		//
		// panelRenaming.add(btnRenamingOperation);
		// btnRenamingOperation.addActionListener(this);

		//
		//
		//
		//
		//
		//
		setLayout(new FlowLayout());
		add(pathDisplay);
		add(btnChoosePath);
		tabbedPane.setBounds(0, 50, 500, 450);
		add(tabbedPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 350);
		setVisible(true);
	}

	private File choosePath() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		File fileName = fileChooser.getSelectedFile();
		return fileName;
	}

	protected void delString(String inputString) {
		Deleter d = new Deleter(subjectPath.toString(), inputString);
		d.deleteUnwantedString();
	}

	protected void addString(String inputString) {
		Add a = new Add();
		a.addWantedString(subjectPath.toString(), inputString);
	}

	private void repString(String replacedString, String replacingString) {
		Replacer r = new Replacer(subjectPath.toString(), replacedString,
				replacingString);
		if (this.btnReplaceOnFirst.isSelected())
			r.stringReplacementFirst();
		else if (this.btnReplaceOnLast.isSelected())
			r.stringReplacementLast();
		else if (this.btnReplaceAll.isSelected())
			r.stringReplacementAll();
	}

	private void numbering(String inputString) {
		Numberer num = new Numberer();
		num.numbering(subjectPath.toString(), inputString);
	}

	private void caseOperationJustDoIt() {
		CaseOperator c = new CaseOperator(subjectPath.toString());
		if (this.btnToCamelCase.isSelected())
			c.toCamelCase();
		else if (this.btnToUpperCase.isSelected())
			c.toUpperCase();
		else if (this.btnToLowerCase.isSelected())
			c.toLowerCase();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!subjectPath.isDirectory()) {
			JOptionPane.showMessageDialog(null, "路徑不正確！");
		}

		if (e.getSource() == this.btnStringOperation) {
			if (btnAddString.isSelected())
				addString(inputString.getText());
			else if (btnDelString.isSelected())
				delString(inputString.getText());
		}

		else if (e.getSource() == this.btnNumberingOperation) {
//			if (numberingStringSaftyCheckBox.isSelected()) {
				if (numberingStringCheckBox.isSelected())
					numbering(numberingString.getText());
				else
					numbering("");
//			}
		}

		else if (e.getSource() == this.btnCaseOperation) {
			caseOperationJustDoIt();
		}

		else if (e.getSource() == this.btnReplacingStringOperation) {
			repString(replacedString.getText(), replacingString.getText());
		}

		// else if (e.getSource() == this.btnRenamingOperation) {
		// if (renamingStringSaftyCheckBox.isSelected()) {
		// if (renamingStringCheckBox.isSelected())
		// numbering(numberingString.getText());
		// else
		// numbering("");
		// }
		// }
	}

}
