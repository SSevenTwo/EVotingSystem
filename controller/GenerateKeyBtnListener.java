package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import view.MainFrame;

public class GenerateKeyBtnListener implements ActionListener {
	
	private MainFrame mainFrame;
	private JTextArea logBox;
	
	public GenerateKeyBtnListener(MainFrame mainFrame, JTextArea logBox) {
		this.mainFrame = mainFrame;
		this.logBox = logBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(mainFrame.getVoteSystem().getKeyPair() != null) {
			return;
		}
		mainFrame.getVoteSystem().generateKey();
		logBox.append(mainFrame.getVoteSystem().getKeyPair().toString());

	}

}
