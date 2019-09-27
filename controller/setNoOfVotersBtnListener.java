package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import view.MainFrame;

public class setNoOfVotersBtnListener implements ActionListener {

	private MainFrame mainFrame;
	private JTextArea logBox;
	
	public setNoOfVotersBtnListener(MainFrame mainFrame, JTextArea logBox) {
		this.mainFrame = mainFrame;
		this.logBox = logBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String noOfVoters = JOptionPane.showInputDialog("Please enter the max number of voters:");
		if(noOfVoters == null){
			   return;
			}
		try {
			mainFrame.getVoteSystem().setNoOfVoters(Integer.parseInt(noOfVoters));
			logBox.append("---------------------------\n"
					+ "\nNumber of Voters Set to: " + Integer.parseInt(noOfVoters) +"\n");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(mainFrame,
					"You must enter a number!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}


	}

}
