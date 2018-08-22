package Simulation;

public class Player {
	private String name;
	private int wins;
	public Player(String name) {
		this.name = name;
		wins = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void incWins() {
		wins++;
	}
}
