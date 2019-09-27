package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import view.MainFrame;

public class ToolBarVABtnListener implements ActionListener {

	private MainFrame mainFrame;

	public ToolBarVABtnListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel passPanel = new JPanel();
		JLabel label = new JLabel("Enter password:");
		JPasswordField password = new JPasswordField(10);
		passPanel.add(label);
		passPanel.add(password);
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, passPanel, "Voting Authority Log In",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[1]);
		
		if(option == 0)
		{
		    char[] passwordFinal = password.getPassword();
		    if(new String(passwordFinal).equals("admin")) {
		    	mainFrame.hideAllPanel();
				mainFrame.add(mainFrame.getVotingAuthorityPanel());
				mainFrame.getVotingAuthorityPanel().setVisible(true);
		    }
		    else {
				JOptionPane.showMessageDialog(mainFrame, "Password is incorrect.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
