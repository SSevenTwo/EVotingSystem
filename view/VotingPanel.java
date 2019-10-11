package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
@SuppressWarnings("serial")
public class VotingPanel extends JPanel{
	
	private VotingButtons votingButtons;
	private JLabel image;
	
	public VotingPanel(MainFrame mainFrame) {

		setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
		this.votingButtons = new VotingButtons(mainFrame);
		image = new JLabel();
		ImageIcon picture = new ImageIcon("candidate.png");
		image.setIcon(picture);
		JPanel imagePanel = new JPanel();
		imagePanel.add(image);
		setLayout(new BorderLayout());
		add(imagePanel,BorderLayout.CENTER);
		add(votingButtons,BorderLayout.SOUTH);
		
		JPanel title = new JPanel();
		JLabel titleFont = new JLabel("Voting Panel");
		titleFont.setFont(titleFont.getFont ().deriveFont (18.0f));
		title.add(titleFont);
		add(title,BorderLayout.NORTH);
	}

	public VotingButtons getVotingButtons() {
		return votingButtons;
	}
	
	

}
