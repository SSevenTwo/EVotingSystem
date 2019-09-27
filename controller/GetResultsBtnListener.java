package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import model.Candidate;
import view.MainFrame;

public class GetResultsBtnListener implements ActionListener {
	private MainFrame mainFrame;
	private JTextArea logBox;

	public GetResultsBtnListener(MainFrame mainFrame, JTextArea logBox) {
		this.mainFrame = mainFrame;
		this.logBox = logBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logBox.append("---------------------------\n" + "Results: \n");
		mainFrame.getVoteSystem().totalVotes();
		for (Candidate candidate : mainFrame.getVoteSystem().getCandidates()) {
			logBox.append(
					String.format("Candidate %s received %d votes.\n", candidate.getName(), candidate.getNoOfVotes()));

		}
		
		Candidate winner = mainFrame.getVoteSystem().determineWinner();
		logBox.append(String.format("The winner is %s!",winner.getName()));
		
	}
}
