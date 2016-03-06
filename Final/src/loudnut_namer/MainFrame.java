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

	JTextField pathDisplay = new JTextField("�п�ܸ�Ƨ����|", 40);
	File subjectPath;
	String specifiedString;

	JTextField inputString = new JTextField("�п�J�Q�n�[�J�ΧR�����r��", 40);
	JButton btnStringOperation = new JButton("�}�l");
	JRadioButton btnAddString = new JRadioButton("�W�[���r��");
	JRadioButton btnDelString = new JRadioButton("�R�����r��", true);

	JCheckBox numberingStringCheckBox = new JCheckBox("�[�J�H�U�r��");
	JTextField numberingString = new JTextField("�п�J�s���e�Q�n�[�J���r��", 20);
	JCheckBox numberingStringSaftyCheckBox = new JCheckBox("�ڪ��D�o�|��쥻�ɦW�q�q�~��");
	JButton btnNumberingOperation = new JButton("�}�l");

	JRadioButton btnToUpperCase = new JRadioButton("����j�g");
	JRadioButton btnToLowerCase = new JRadioButton("����p�g");
	JRadioButton btnToCamelCase = new JRadioButton("���r���j�g��l�p�g", true);
	JButton btnCaseOperation = new JButton("�}�l");

	JTextField replacedString = new JTextField("�ؼЦr��", 40);
	JTextField replacingString = new JTextField("���N��...", 40);
	JRadioButton btnReplaceOnFirst = new JRadioButton("�@�Ω�̫e");
	JRadioButton btnReplaceOnLast = new JRadioButton("�@�Ω�̫�");
	JRadioButton btnReplaceAll = new JRadioButton("�@�Ω����");
	JButton btnReplacingStringOperation = new JButton("�}�l");

	// JCheckBox renamingStringCheckBox = new JCheckBox("�[�J�H�U�r��");
	// JCheckBox renamingStringSaftyCheckBox = new JCheckBox("�ڪ��D�o�|��쥻�ɦW�q�q�~��");
	// JTextField renamingString = new JTextField("�п�J�s���e�Q�n�[�J���r��", 20);
	// JButton btnRenamingOperation = new JButton("�}�l");

	public MainFrame() {
		super("loudnut Namer v.21");
		System.out
				.println("v.21 : Numbering tab is not limited to *.mp3 anymore");

		pathDisplay.setEditable(false);

		JButton btnChoosePath = new JButton("��ܸ��|");

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
		JLabel label1 = new JLabel("�b�ɦW���R���Φb�}�Y�[�J���w�r��", SwingConstants.CENTER);
		JPanel panelString = new JPanel();
		JPanel panelStringIn1 = new JPanel();
		panelString.setLayout(new GridLayout(0, 1));
		panelString.add(label1, BorderLayout.NORTH);
		panelString.add(panelStringIn1, BorderLayout.WEST);

		tabbedPane.addTab("�W�R�r��", null, panelString);

		panelStringIn1.setLayout(new FlowLayout());

		// JTextField inputString = new JTextField("�п�J�Q�n�[�J�ΧR�����r��", 40);
		panelString.add(inputString);

		// JRadioButton btnAddString = new JRadioButton("�W�[���r��");
		panelString.add(btnAddString);
		// JRadioButton btnDelString = new JRadioButton("�R�����r��", true);
		panelString.add(btnDelString);
		ButtonGroup groupString = new ButtonGroup();
		groupString.add(btnAddString);
		groupString.add(btnDelString);

		// JButton btnStringOperation = new JButton("�}�l");
		panelString.add(btnStringOperation);
		btnStringOperation.addActionListener(this);
		//
		//
		//
		//
		//
		//
		// set up panelNumbering and add it to JTabbedPane
		JLabel label2 = new JLabel("�b�ɦW�}�Y�[�W�s��", SwingConstants.CENTER);
		JPanel panelNumbering = new JPanel();
		JPanel panelNumberingIn1 = new JPanel();

		panelNumbering.setLayout(new GridLayout(0, 1));
		panelNumbering.add(label2, BorderLayout.NORTH);
		panelNumbering.add(panelNumberingIn1, BorderLayout.WEST);

		tabbedPane.addTab("�W�s��", null, panelNumbering);

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
		JLabel label3 = new JLabel("�ഫ�ɦW�j�p�g", SwingConstants.CENTER);
		JPanel panelCaseSwitch = new JPanel();

		panelCaseSwitch.setLayout(new GridLayout(0, 1));
		panelCaseSwitch.add(label3, BorderLayout.NORTH);

		tabbedPane.addTab("�j�p�g����", null, panelCaseSwitch);

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
		JLabel label4 = new JLabel("�N�S�w�r����N�����w�r��", SwingConstants.CENTER);
		JPanel panelStringReplacement = new JPanel();

		panelStringReplacement.setLayout(new GridLayout(0, 1));
		panelStringReplacement.add(label4, BorderLayout.NORTH);

		tabbedPane.addTab("���N�r��", null, panelStringReplacement);

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
		// JLabel label5 = new JLabel("�����ۭq�ɦW�P�s��", SwingConstants.CENTER);
		// JPanel panelRenaming = new JPanel();
		// JPanel panelRenamingIn1 = new JPanel();
		//
		// panelRenaming.setLayout(new GridLayout(0, 1));
		// panelRenaming.add(label5, BorderLayout.NORTH);
		// panelRenaming.add(panelRenamingIn1, BorderLayout.WEST);
		//
		// tabbedPane.addTab("�ۭq�ɦW", null, panelRenaming);
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
			JOptionPane.showMessageDialog(null, "���|�����T�I");
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
