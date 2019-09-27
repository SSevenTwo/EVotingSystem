package client;
import javax.swing.SwingUtilities;

import view.MainFrame;

public class Driver {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MainFrame();

			}

		});
//		KeyGenerator key = new KeyGenerator();
//		EVotingSystem voteSystem = new EVotingSystem(50,key.getPublicKey(),key.getPrivateKey());
//		voteSystem.addCandidate("Huy's Arse");
//		voteSystem.addCandidate("Obama");
//		voteSystem.addCandidate("Roger Federer");
//		voteSystem.addCandidate("Trump");
//		
//		voteSystem.setUpVotingSystem();
//		
//		ArrayList<Candidate> candidates = voteSystem.getCandidates();
//		
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(0));
//		
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(1));
//		
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		voteSystem.vote(candidates.get(3));
//		
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(1));
//		
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(1));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		voteSystem.vote(candidates.get(2));
//		
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(0));
//		voteSystem.vote(candidates.get(0));
//		
//		voteSystem.totalVotes();
//		voteSystem.determineWinner();
	}

}



