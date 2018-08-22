package Simulation;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many dice rolls do you want to allow?");
		int n = scan.nextInt();
		Player[] players = {new Player(),new Player()};
		Craps game = new Craps(players, 3);
		for(int i = 0; i < n; i++) {
			game.runTurn();
		}
		double flipWin = game.getNumTimeFlipWin();
		double percentageFlipWin = flipWin / (players[0].getWins() + players[1].getWins())*100;
		System.out.println("The person who one the coin flip won " + game.getNumTimeFlipWin()+ " matches");
		System.out.println("out of a total of " + (players[0].getWins() + players[1].getWins())+ " matches.");
		System.out.println("This means the person who wins the coin flip won " + percentageFlipWin);
	}
}
