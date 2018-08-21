package Simulation;
import java.util.Random;

public class Craps {
	private static final int WIN_CONDITION_ONE = 7;
	private static final int WIN_CONDITION_TWO = 11;
	private static final int RE_ROLL = 12;
	private static final int AUTO_LOSS = 2;
	private String[] players;
	private boolean winningRoll;
	
	public Craps(String[] players) {
		this.players = players;
		winningRoll = false;
	}
	
	public boolean runTurn() {
		Random rand = new Random();
		int numRolled = rand.nextInt(6) + rand.nextInt(6) + 2;
		switch(numRolled) {
			case RE_ROLL: //reroll
				runTurn();
				break;
			case WIN_CONDITION_ONE: //win con
				if(gameOver()) {
					
				}
				break;
			case WIN_CONDITION_TWO:// win con
				break;
			case AUTO_LOSS:// auto loss
				break;
		}
		return false;
	}
	
	private boolean gameOver() {
		if(winningRoll) {
			return true;
		}
		return false;
	}
}
