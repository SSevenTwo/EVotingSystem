package model;

public class Candidate {
	
	private static int number = 0;
	
	private int id;
	private int noOfVotes;
	private String name;
	
	public Candidate(String name) {
		this.name = name;
		this.id = number;
		number++;
	}

	public int getID() {
		return id;
	}
	
	public int getNoOfVotes() {
		return noOfVotes;
	}
	
	public void setNoOfVotes(int votes) {
		noOfVotes = votes;
	}

	public String getName() {
		return name;
	}
	
	
	
}
