package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Candidate;
import view.MainFrame;
import view.VotingButtons;

public class VoteBtnListener implements ActionListener {

	private MainFrame mainFrame;
	private VotingButtons votingButtonsPanel;

	public VoteBtnListener(MainFrame mainFrame, VotingButtons votingButtonsPanel) {
		this.mainFrame = mainFrame;
		this.votingButtonsPanel = votingButtonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

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

	}

}
