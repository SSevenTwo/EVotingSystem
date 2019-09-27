package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.MainFrame;

public class ToolbarVotingBtnListener implements ActionListener {

	private MainFrame mainFrame;
	
	public ToolbarVotingBtnListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton voteBtn = mainFrame.getVotingPanel().getVotingButtons().getVoteBtn();
		mainFrame.getVotingPanel().getVotingButtons().setRemainingVotes();
		mainFrame.getVotingPanel().getVotingButtons().setCandidate(mainFrame.getVoteSystem().getCandidates(), voteBtn);
		mainFrame.hideAllPanel();
		mainFrame.add(mainFrame.getVotingPanel());
		mainFrame.getVotingPanel().setVisible(true);

		mainFrame.getVotingPanel().getVotingButtons().refreshVotingBtn();

	}

}
