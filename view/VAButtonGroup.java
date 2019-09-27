package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import controller.GenerateKeyBtnListener;
import controller.GetResultsBtnListener;
import controller.addCandidateBtnListener;
import controller.setNoOfVotersBtnListener;

public class VAButtonGroup extends JPanel {
	private JButton generateKeyBtn;
	private JButton setNoOfVotersBtn;
	private JButton addCandidateBtn;
	private JButton getResults;

	private MainFrame mainFrame;
	private JTextArea logBox;

	public VAButtonGroup(MainFrame mainFrame, JTextArea logBox) {

		this.mainFrame = mainFrame;
		this.logBox = logBox;

		setLayout(new FlowLayout());
		setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
		generateKeyBtn = new JButton("Generate Key");
		setNoOfVotersBtn = new JButton("Set No. of Voters");
		addCandidateBtn = new JButton("Add Candidate");
		getResults = new JButton("Calculate Results");
		getResults.setEnabled(false);

		generateKeyBtn.addActionListener(new GenerateKeyBtnListener(mainFrame, logBox));
		setNoOfVotersBtn.addActionListener(new setNoOfVotersBtnListener(mainFrame, logBox));
		addCandidateBtn.addActionListener(new addCandidateBtnListener(mainFrame, logBox));
		getResults.addActionListener(new GetResultsBtnListener(mainFrame, logBox));

		add(generateKeyBtn);
		add(setNoOfVotersBtn);
		add(addCandidateBtn);
		add(getResults);
	}

	public JButton getGetResults() {
		return getResults;
	}

	public void disableButtons() {
		generateKeyBtn.setEnabled(false);
		setNoOfVotersBtn.setEnabled(false);
		addCandidateBtn.setEnabled(false);
	}

}
