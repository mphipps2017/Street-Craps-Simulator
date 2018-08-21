package Simulation;

public class Player {
	private String name;
	private int wins;
	private int losses;
	public Player(String name) {
		this.name = name;
		wins = 0;
		losses = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
}
