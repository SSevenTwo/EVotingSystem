package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import controller.ToolBarVABtnListener;
import controller.ToolbarVotingBtnListener;

public class Toolbar extends JPanel {

	private MainFrame mainFrame;
	private JButton votingAuthorityBtn;
	private JButton votingBtn;

	public Toolbar(MainFrame mainFrame) {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
		this.mainFrame = mainFrame;
		this.votingAuthorityBtn = new JButton("Voting Authority Panel");
		this.votingBtn = new JButton("Voting Panel");
		
		votingBtn.addActionListener(new ToolbarVotingBtnListener(mainFrame));
		votingAuthorityBtn.addActionListener(new ToolBarVABtnListener(mainFrame));
		
		add(votingAuthorityBtn);
		add(votingBtn);

	}

	public JButton getVotingAuthorityBtn() {
		return votingAuthorityBtn;
	}

	public JButton getVotingBtn() {
		return votingBtn;
	}


}
