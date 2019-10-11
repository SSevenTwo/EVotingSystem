package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.SetUpVoteSystemBtnListener;
@SuppressWarnings("serial")
public class VotingAuthorityPanel extends JPanel {

	private VAButtonGroup buttons;
	
	private JButton setUpVoteSystemBtn;
	
	private JTextArea logBox;

	public VotingAuthorityPanel(MainFrame mainFrame) {
		
		setUpVoteSystemBtn = new JButton("Set Up System for Voters");
		logBox = new JTextArea();
		logBox.setEditable(false);
		
		logBox.append("Welcome Voting Authority:\n"
				+ "**********************************\n"
				+ "Instructions: \n"
				+ "1. Please generate a key.\n"
				+ "2. Please set the number of voters. Optional: You can randomize the voter passwords.\n"
				+ "3. Please add at least 2 candidates.\n"
				+ "4. Press the set up button below for voters to begin using the system.\n");
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
