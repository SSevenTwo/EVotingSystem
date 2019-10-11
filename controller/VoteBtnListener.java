package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import model.Candidate;
import model.EVotingSystem;
import model.Voter;
import view.MainFrame;
import view.VotingButtons;

public class VoteBtnListener implements ActionListener {

	private MainFrame mainFrame;
	private VotingButtons votingButtonsPanel;
	private EVotingSystem system;

	public VoteBtnListener(MainFrame mainFrame, VotingButtons votingButtonsPanel) {
		this.mainFrame = mainFrame;
		this.votingButtonsPanel = votingButtonsPanel;
		this.system = mainFrame.getVoteSystem();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (loginVoter()) {
			String candidateVoted = (String) votingButtonsPanel.getCandidatesBox().getSelectedItem();
			String[] nameAndId = candidateVoted.split(":");
			String candidateId = nameAndId[1].trim();
			ArrayList<Candidate> candidateList = mainFrame.getVoteSystem().getCandidates();

			for (Candidate candidate : candidateList) {
				if (candidate.getID() == Integer.parseInt(candidateId)) {
					mainFrame.getVoteSystem().vote(candidate);
				}
			}

			votingButtonsPanel.increaseVoteCount();
			if (votingButtonsPanel.getVoteCount() == votingButtonsPanel.getMaxNumberOfVotes()) {
				votingButtonsPanel.getVoteBtn().setEnabled(false);
				JOptionPane.showMessageDialog(mainFrame,
						"No more votes remaining. Voting Authority should total the votes.", "Voting Concluded",
						JOptionPane.INFORMATION_MESSAGE);
				mainFrame.getVotingAuthorityPanel().getButtons().getGetResults().setEnabled(true);
			}
		} else {
			JOptionPane.showMessageDialog(mainFrame, "Either: Password/ID is invalid or you have already voted.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public boolean loginVoter() {
		boolean valid = false;
		String voterID = JOptionPane.showInputDialog("Please enter your voter ID:");
		String voterPass = passwordInput();

		if (voterID == null || voterID.equals("") || voterPass == null || voterPass.equals("")) {
			return false;
		}

		for (Voter voter : system.getVoters()) {
			if (voter.getId().equals(voterID)) {
				if (voter.getPassword().equals(voterPass)) {
					if (!voter.isHasVoted()) {
						valid = true;
						voter.voted();
					}
				}
			}
		}

		return valid ? true : false;

	}

	private String passwordInput() {
		JPanel passPanel = new JPanel();
		JLabel label = new JLabel("Enter password:");
		JPasswordField password = new JPasswordField(10);
		passPanel.add(label);
		passPanel.add(password);
		String[] options = new String[] { "OK", "Cancel" };
		int option = JOptionPane.showOptionDialog(null, passPanel, "Voter Password", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

		if (option == 0) {
			return new String(password.getPassword());
		}
		else return null;
	}
}
