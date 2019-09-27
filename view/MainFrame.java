package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import controller.ToolBarVABtnListener;
import controller.ToolbarVotingBtnListener;
import model.EVotingSystem;

public class MainFrame extends JFrame {

	private EVotingSystem voteSystem;
	private VotingAuthorityPanel votingAuthorityPanel;
	private VotingPanel votingPanel;
	private Toolbar toolbar;
	private HomePanel homePanel;

	public MainFrame() {
		super("E-Voting System");
		setLayout(new BorderLayout());
		homePanel = new HomePanel();
		this.voteSystem = new EVotingSystem();
		toolbar = new Toolbar(this);
		votingAuthorityPanel = new VotingAuthorityPanel(this);
		votingPanel = new VotingPanel(this);
		votingAuthorityPanel.setVisible(false);
		votingPanel.setVisible(false);
		
		add(toolbar,BorderLayout.NORTH);
		add(votingAuthorityPanel,BorderLayout.CENTER);
		add(votingPanel,BorderLayout.CENTER);
		add(homePanel,BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(600, 300));
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	
	}
	

	public EVotingSystem getVoteSystem() {
		return voteSystem;
	}

	public VotingAuthorityPanel getVotingAuthorityPanel() {
		return votingAuthorityPanel;
	}

	public VotingPanel getVotingPanel() {
		return votingPanel;
	}


	public void hideAllPanel() {
		votingAuthorityPanel.setVisible(false);
		votingPanel.setVisible(false);
		homePanel.setVisible(false);
		
	}


	public Toolbar getToolbar() {
		return toolbar;
	}

}
