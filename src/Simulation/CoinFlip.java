package Simulation;
import java.util.Random;

public class CoinFlip {
	public int flip() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
}
