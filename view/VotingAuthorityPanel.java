package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.SetUpVoteSystemBtnListener;

public class VotingAuthorityPanel extends JPanel {

	private MainFrame mainFrame;
	private VAButtonGroup buttons;
	
	private JButton setUpVoteSystemBtn;
	
	private JTextArea logBox;

	public VotingAuthorityPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		
		setUpVoteSystemBtn = new JButton("Set Up System for Voters");
		logBox = new JTextArea();
		logBox.setEditable(false);
		
		logBox.append("Welcome Voting Authority:\n"
				+ "**********************************\n"
				+ "Instructions: \n"
				+ "1. Please generate a key.\n"
				+ "2. Please set the number of voters.\n"
				+ "3. Please add at least 2 candidates.\n"
				+ "4. Press the set up button below for voters to being using the system.\n");
		this.buttons = new VAButtonGroup(mainFrame, logBox);

		setLayout(new BorderLayout());
		
		setUpVoteSystemBtn.addActionListener(new SetUpVoteSystemBtnListener(mainFrame,logBox));

		add(buttons, BorderLayout.NORTH);
		add(new JScrollPane(logBox), BorderLayout.CENTER);
		add(setUpVoteSystemBtn, BorderLayout.SOUTH);

	}

	public JTextArea getLogBox() {
		return logBox;
	}

	public VAButtonGroup getButtons() {
		return buttons;
	}
	
	
	
	

}
