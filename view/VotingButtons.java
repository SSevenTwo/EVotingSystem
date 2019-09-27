package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import controller.VoteBtnListener;
import model.Candidate;

public class VotingButtons extends JPanel {

	private JButton voteBtn;
	private Collection<Candidate> candidates;
	private JComboBox<String> candidatesBox;
	private JLabel votesRemaining;
	private MainFrame mainFrame;
	private int maxNumberOfVotes;
	private int voteCount;

	public VotingButtons(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		candidates = mainFrame.getVoteSystem().getCandidates();
		voteBtn = new JButton("Vote");
		this.voteCount = 0;
		votesRemaining = new JLabel();
		setRemainingVotes();

		candidatesBox = new JComboBox<String>();
		this.setCandidate(candidates, voteBtn);

		voteBtn.addActionListener(new VoteBtnListener(mainFrame, this));

		setLayout(new FlowLayout());

		setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));

		add(candidatesBox);
		add(voteBtn);
		add(votesRemaining);

	}

	public void setRemainingVotes() {

		if (mainFrame.getVoteSystem().getNoOfVoters() != null) {
			this.maxNumberOfVotes = mainFrame.getVoteSystem().getNoOfVoters();
		} else {
			this.maxNumberOfVotes = 0;
		}
		this.votesRemaining.setText("Votes remaining: " + (maxNumberOfVotes - voteCount));

	}

	public void setCandidate(Collection<Candidate> candidates, JButton button) {
		this.candidates = candidates;
		refreshComboBox(button);
		this.removeAll();
		add(candidatesBox);
		add(button);
		add(votesRemaining);
		setRemainingVotes();
		updateButtonState(button);
		revalidate();
		repaint();
	}

	public void refreshComboBox(JButton button) {
		// Setup or refresh combo box upon removing players
		remove(candidatesBox);
		this.candidatesBox = new JComboBox<String>();
		addCandidatesToComboBox();
		this.updateButtonState(button);
	}

	public void updateButtonState(JButton button) {
		if (candidatesListIsEmpty()) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
	}

	private boolean candidatesListIsEmpty() {
		if (candidates.size() == 0 || candidates == null) {
			return true;
		} else
			return false;
	}

	private void addCandidatesToComboBox() {
		DefaultComboBoxModel<String> combo = new DefaultComboBoxModel<String>();
		for (Candidate candidate : candidates) {
			combo.addElement(String.format("%s : %s", candidate.getName(), candidate.getID()));
			this.candidatesBox.setModel(combo);
		}
	}

	public JButton getVoteBtn() {
		return voteBtn;
	}

	public JComboBox<String> getCandidatesBox() {
		return candidatesBox;
	}

	public int getMaxNumberOfVotes() {
		return maxNumberOfVotes;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteBtn(JButton voteBtn) {
		this.voteBtn = voteBtn;
	}

	public void increaseVoteCount() {
		this.voteCount++;
		setRemainingVotes();
	}

	public void refreshVotingBtn() {
		if (mainFrame.getVoteSystem().getKeyPair() == null || mainFrame.getVoteSystem().getCandidates() == null
				|| mainFrame.getVoteSystem().getCandidates().size() < 2
				|| mainFrame.getVoteSystem().getNoOfVoters() == null) {
			voteBtn.setEnabled(false);
		} else {
			voteBtn.setEnabled(true);
		}
	}
}
