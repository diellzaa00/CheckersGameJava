package checkersgame;
import java.io.*;


public class TestCheckers {
	public static void main(String[] args) throws IOException{

		OutputCheckers outputcheckers = new OutputCheckers();

	
		outputcheckers.printBoard();
		
		//Loop until game is over
		while (!outputcheckers.gameOver()) {
			outputcheckers.getNextMove();
			outputcheckers.printBoard();
		}
		
		// Anounce winner
		System.out.println(outputcheckers.winnerIs());
	}
}
