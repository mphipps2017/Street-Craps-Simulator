package Simulation;
import java.util.Random;

public class Craps {
	private static final int WIN_CONDITION_ONE = 7;
	private static final int WIN_CONDITION_TWO = 11;
	private static final int RE_ROLL = 12;
	private static final int AUTO_LOSS = 2;
	private Player[] players;
	private int[] wins;
	private boolean winningRoll;
	private int currentPlayer;
	private int roundsInMatch;
	private int flipWinner;
	private int numTimesFlipWin;
	private Random rand = new Random();
	
	public Craps(Player[] players, int roundsInMatch) {
		this.players = players;
		winningRoll = false;
		wins = new int[players.length];
		for(int i : wins)
			i = 0;
		currentPlayer = rand.nextInt(2);
		flipWinner = currentPlayer;
		this.roundsInMatch = roundsInMatch;
		numTimesFlipWin = 0;
	}
	
	public void runTurn() {
		boolean reRoll = false;
		Random rand = new Random();
		int numRolled = rand.nextInt(6) + rand.nextInt(6) + 2;
		switch(numRolled) {
			case RE_ROLL: // reroll
				reRoll = true;
				break;
			case WIN_CONDITION_ONE: // win con
				if(winningRoll) {
					winningRoll = false;
				}
				else
					winningRoll = true;
				break;
			case WIN_CONDITION_TWO:// win con
				if(winningRoll) {
					winningRoll = false;
				}
				else
					winningRoll = true; 
				break;
			case AUTO_LOSS:// auto loss
					resetGame();
				break;
			default:
				if(winningRoll) {
					resetGame();
				}
		}
		if(!reRoll) {
			currentPlayer = (currentPlayer > 0) ? 0 : 1; // Changes Current Player
		}
	}
	
	private void resetGame() {
		winningRoll = false;
		wins[(currentPlayer > 0) ? 0 : 1]++;
		for(int i = 0; i < wins.length; i++) {
			if(wins[i] > roundsInMatch/2) {
				players[i].incWins();
				if(i == flipWinner)
					numTimesFlipWin++;
				newMatch();
			}
				
		}
	}
	
	private int newMatch() {
		for(int i: wins) {
			i = 0;
		}
		currentPlayer = rand.nextInt(2);
		flipWinner = currentPlayer;
		return 0;
	}
	
	public int getNumTimeFlipWin() {
		return numTimesFlipWin;
	}
}