package checkersgame;


import java.io.IOException;

import java.util.Scanner;

public class InputCheckers extends CheckMove {
	/** This method executes one move, the throws exception in the head
	 * of the method means that the method can potentially 'throw' a certain exception */
	public void getNextMove() throws IOException {
		Scanner input = new Scanner(System.in);
		if (whosemove == 'w') {
			System.out.println("It is your turn, Player 1.");
		}
		else {
			System.out.println("It is your turn, Player 2.");
		}
		boolean moved = false;
		
		//If a legal move is not entered, continue (loop) until it is entered
		while (!moved) {
			// Read the square to move from which to whom
			System.out.println("Enter the number of square you would like to move from");
			System.out.println("Enter as a two digit number(e.g if you are moving from x = 2; y = 3 write 23): ");
			int movefrom = input.nextInt();
			
			System.out.println("Enter the number of the square you would like to move, using the same way: ");
			int moveto = input.nextInt();
			
			//Checks to see if a move is valid and only then executes it.
			if (validMove(movefrom, moveto)) {
				executeMove(movefrom, moveto);
				moved = true;
			} else {
				System.out.println("That was an invalid move, please write a valid one!");
			}
		}
		
		// Update whoever move it is
		if (whosemove == 'w') {
			whosemove = 'b';
		} else {
			whosemove = 'w';
		}		
	}
}
