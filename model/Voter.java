package model;

import java.util.Random;

public class Voter {
	private static int idCount = 0;
	
	private String id;
	private String password;
	private boolean hasVoted;
	
	public Voter() {
		this.id = "" + Voter.idCount;
		this.password = "password";
		this.hasVoted = false;
		idCount++;
	}
	
	public void randomizePassword() {
		Random rand = new Random();
		this.password = "" + rand.nextInt(99999999);
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public void voted() {
		this.hasVoted = true;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}
	
	
}
