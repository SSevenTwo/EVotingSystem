package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.EVotingSystem;
import view.MainFrame;

public class SetUpVoteSystemBtnListener implements ActionListener {

	private MainFrame mainFrame;
	JTextArea logBox;

	public SetUpVoteSystemBtnListener(MainFrame mainFrame, JTextArea logBox) {
		this.mainFrame = mainFrame;
		this.logBox = logBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EVotingSystem system = mainFrame.getVoteSystem();
		if (system.getNoOfVoters() != null && !system.getCandidates().isEmpty() && system.getKeyPair() != null) {
			mainFrame.getVoteSystem().setUpVotingSystem();
			mainFrame.getVotingAuthorityPanel().getButtons().disableButtons();
			logBox.append("---------------------------\nVoting System has been set up. Voters can begin voting. \n");
		} else {
			JOptionPane.showMessageDialog(mainFrame, "You have not set one of the key parameters above.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
