package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
	
	private JPanel title;
	private JPanel author;
	private JPanel image;
	
	public HomePanel() {
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		
		image = new JPanel();
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("vote.png");
		JLabel labelWithIcon = new JLabel();
		labelWithIcon.setIcon(icon);
		image.add(labelWithIcon);
		
		add(image,BorderLayout.CENTER);
		
		title = new JPanel();
		JLabel titleFont = new JLabel("<html>Paillier E-Voting System Demo<br>   By Ian Nguyen (S3788210)</html>");
		titleFont.setFont(titleFont.getFont ().deriveFont (18.0f));
		title.add(titleFont);
		add(title,BorderLayout.NORTH);
		
		author = new JPanel();
		JLabel authorFont = new JLabel("<html><div>Icons made by <a href=\"https://www.flaticon.com/authors/freepik\" title='Freepik'>Freepik</a> from <a href='https://www.flaticon.com/' title='Flaticon'>www.flaticon.com</a></div></html>");
		authorFont.setFont(authorFont.getFont ().deriveFont (12.0f));
		author.add(authorFont);
		add(author,BorderLayout.SOUTH);
		
	}

}
