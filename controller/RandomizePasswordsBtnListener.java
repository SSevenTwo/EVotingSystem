package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.EVotingSystem;
import model.Voter;
import view.MainFrame;

public class RandomizePasswordsBtnListener implements ActionListener {
	private MainFrame mainFrame;
	private JTextArea logBox;

	public RandomizePasswordsBtnListener(MainFrame mainFrame, JTextArea logBox) {
		this.mainFrame = mainFrame;
		this.logBox = logBox;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EVotingSystem system = mainFrame.getVoteSystem();
		if (system.getVoters() == null) {
			JOptionPane.showMessageDialog(mainFrame,
					"You have not set the number of voters.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			for (Voter vote : system.getVoters()) {
				vote.randomizePassword();
				logBox.append("---------------------------\n" + "Voter ID: " + vote.getId() + " | Password : "
						+ vote.getPassword() + "\n");
			}
			logBox.append("---------------------------\n"
					+ "Passwords for every voter has been randomized. Please inform voters of their new passwords.\n");
		}
	}

}
