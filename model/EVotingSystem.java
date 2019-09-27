package model;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EVotingSystem {

	private ArrayList<Candidate> candidates;
	private ArrayList<BigInteger> votes;
	private Integer noOfCandidates;
	private Integer noOfVoters;
	private Integer maxNumberRepresentedBySingleVote;
	private Integer maximumPossibleBinaryForSingleCandidate;
	private String binaryRepresetntationOfMaxNo;
	private BigInteger totalVotes;
	private int lengthOfOneBinaryVote;
	private int lengthOfBinaryTally;
	
	private KeyGenerator keyPair;
	private PublicKey publicKey;
	private PrivateKey privateKey;

	public EVotingSystem() {
		this.votes = new ArrayList<BigInteger>();
		this.candidates = new ArrayList<Candidate>();
	}
	
	public void setNoOfVoters(Integer noOfVoters) {
		this.noOfVoters = noOfVoters;
	}
	
	public void generateKey() {
		this.keyPair = new KeyGenerator();
		this.privateKey = keyPair.getPrivateKey();
		this.publicKey = keyPair.getPublicKey();
	}
	
	public void addCandidate(String name) {
		candidates.add(new Candidate(name));
		noOfCandidates = candidates.size();
	}
	
	public void setUpVotingSystem() {
		System.out.println("Number of candidates: " + noOfCandidates);

		System.out.println("Number of voters: " + noOfVoters);

		// Largest voting message
		determineLengthOfOneBinaryVote();

		// Tally Length
		determineLengthOfTally();

		// If all voters voted for the same candidate
		determineLargestBinaryPossible();
	}

	public void vote(Candidate candidate) {
		StringBuilder voteBinary = determineUserBinaryVote(candidate.getID());

		String no = "" + Integer.parseInt(voteBinary.toString(), 2);
		BigInteger bigIntegerVote = new BigInteger(no);

		System.out.println("PlainText Vote= " + bigIntegerVote);
		BigInteger encryptedVote = publicKey.encrypt(bigIntegerVote);
		votes.add(encryptedVote);
		System.out.println("Encrypted Vote= " + encryptedVote);
	}
	
	private StringBuilder determineUserBinaryVote(int candidateNo) {
		StringBuilder voteBinary = new StringBuilder("");

		for (int i = 0; i < lengthOfBinaryTally; i++) {
			voteBinary.append("0");
		}

		int lengthOfOneVote = lengthOfBinaryTally / noOfCandidates;

		int indexOfCandidate = (lengthOfBinaryTally - 1) - (candidateNo * lengthOfOneVote);
		voteBinary.setCharAt(indexOfCandidate, '1');
		System.out.println("PlainText Binary Vote=" + voteBinary);
		
		return voteBinary;
	}

	public void totalVotes() {
		homomorphicAdditionOfVotes();

		BigInteger decimalTally = decryptTally();

		System.out.println("Decrypted Decimal = " + decimalTally);

		// Binary result
		String binaryTally = convertDecimalTallyToBinary(decimalTally);

		assignVotesToCandidate(binaryTally);
	}

	private void assignVotesToCandidate(String binaryTally) {
		List<String> votes = getSubStrings(binaryTally, lengthOfOneBinaryVote);
		int power = noOfCandidates - 1;
		int j = 0;
		for (int i = power; i >= 0; i--) {
			int a = Integer.parseInt(votes.get(j), 2);
			System.out.println(String.format("Candidate %d : %s received %d votes!", candidates.get(i).getID(),
					candidates.get(i).getName(), a));
			candidates.get(i).setNoOfVotes(a);
			power--;
			j++;
		}
	}

	public Candidate determineWinner() {
		Candidate winner = candidates.get(0);
		for (int i = 0; i < candidates.size(); i++) {
			if (winner.getNoOfVotes() < candidates.get(i).getNoOfVotes()) {
				winner = candidates.get(i);
			}
		}

		System.out.println(String.format("The winner is %s!", winner.getName()));

		return winner;
	}

	private BigInteger decryptTally() {
		return privateKey.decrypt(totalVotes);
	}

	private void homomorphicAdditionOfVotes() {
		totalVotes = new BigInteger("1");
		for (BigInteger vote : votes) {
			totalVotes = vote.multiply(totalVotes).mod(publicKey.getNSquared());
		}
	}

	private String convertDecimalTallyToBinary(BigInteger decimalTally) {
		int num = Integer.parseInt(decimalTally.toString());
		String binaryTally = Integer.toBinaryString(num);

		if (binaryTally.length() != lengthOfBinaryTally) {
			String temp = binaryTally;
			binaryTally = "";
			for (int i = 0; i < (lengthOfBinaryTally - temp.length()); i++) {
				binaryTally += "0";
			}
			binaryTally += temp;
		}
		System.out.println("Decrypted Binary = " + binaryTally);

		return binaryTally;

	}

	private List<String> getSubStrings(String string, int partitionSize) {
		List<String> parts = new ArrayList<String>();
		int len = string.length();
		for (int i = 0; i < len; i += partitionSize) {
			parts.add(string.substring(i, Math.min(len, i + partitionSize)));
		}
		return parts;
	}

	private void determineLengthOfOneBinaryVote() {
		maxNumberRepresentedBySingleVote = noOfVoters;
		binaryRepresetntationOfMaxNo = Integer.toBinaryString(noOfVoters);
		lengthOfOneBinaryVote = binaryRepresetntationOfMaxNo.length();
		System.out.println("Binary of Max Number: " + binaryRepresetntationOfMaxNo);
		System.out.println("LENGTH OF BINARY: " + lengthOfOneBinaryVote);
	}
	
	private void determineLengthOfTally() {
		lengthOfBinaryTally = binaryRepresetntationOfMaxNo.length() * noOfCandidates;
		System.out.println("LENGTH OF TALLY: " + lengthOfBinaryTally);
	}
	
	private void determineLargestBinaryPossible() {
		int length = lengthOfBinaryTally - binaryRepresetntationOfMaxNo.length();
		String maxPossibleBinaryString = binaryRepresetntationOfMaxNo;
		for (int i = 0; i < length; i++) {
			maxPossibleBinaryString += "0";
		}
		maximumPossibleBinaryForSingleCandidate = maxNumberRepresentedBySingleVote * noOfVoters;
		System.out.println("MAX POSSIBLE BINARY STRING = " + maxPossibleBinaryString);
	}

	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}

	public KeyGenerator getKeyPair() {
		return keyPair;
	}

	public Integer getNoOfVoters() {
		return noOfVoters;
	}
	
	
	
	
	
}
