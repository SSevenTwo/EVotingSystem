package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import view.MainFrame;

public class addCandidateBtnListener implements ActionListener {

	private MainFrame mainFrame;
	private JTextArea logBox;
	
	public addCandidateBtnListener(MainFrame mainFrame, JTextArea logBox) {
		this.mainFrame = mainFrame;
		this.logBox = logBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nameOfCandidate = JOptionPane.showInputDialog("Please enter name of the candidate:");
		if(nameOfCandidate == null || nameOfCandidate.equals("")){
			   return;
			}
		mainFrame.getVoteSystem().addCandidate(nameOfCandidate);
		logBox.append("---------------------------\n"
				+ "Candidate " + nameOfCandidate + " added.\n");

	}

}
