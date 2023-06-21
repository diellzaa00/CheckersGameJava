package checkersgame;

import java.io.IOException;
import java.util.Scanner;

public class CheckMove extends Checkers {
	
	/** Checks if a move is valid, returns true if it is and false if it is not
	 * @param movefrom - the coordinates of the square which will be moved
	 * @param moveto - the coordinates where the square will be moved
	 */
	public boolean validMove(int movefrom, int moveto) {
		
		// Gets array indeces corresponding to the move, from parameters.
		// Since x is considered the tens digit we will divide it by 10, and since y is the singular digit we'll take %10
		int xfrom = movefrom / 10 - 1;
		int yfrom = movefrom % 10 - 1;
		int xto = moveto / 10 - 1;
		int yto = moveto % 10 - 1;
		
		//Check if indeces are in range, if not return false
		if (xfrom < 0 || xfrom > 8 || yfrom < 0 || yfrom > 8  || xto < 0 || xto > 8 || yto < 0 || yto > 8) {
			return false;
		}
		
		// Check to see if you are moving your piece to a blank space
		else if (board[xfrom][yfrom] == whosemove && board[xto][yto] == '_') {
			// Check case of a simple move
			if (Math.abs(xfrom - xto) == 1) {
				if ((whosemove == 'w' ) && (yto - yfrom  == 1))
					return true;
				else if ((whosemove == 'b') && (yto - yfrom == -1))
					return true;
			}
			// Check case of a jump
			else if (Math.abs(xfrom - xto) == 2) {
				if (whosemove == 'w' && (yto - yfrom == 2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'b') {
					return true;
				} 
				else if (whosemove == 'b' && (yto - yfrom == -2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'w') {
					return true;
				}
			}
		}
		// If a move is not a simple one or a jump then it is not legal
		return false;
	}
		
	
	/** The method executes a move after we have checked that the indeces are valid
	 * @param movefrom - the coordinates of the piece that is to be moved
	 * #param moveto - the coordinates of the piece where it is to be moved
	 */
	public void executeMove(int movefrom, int moveto) {
		//Gets array indeces corresponding to the move, from parameters
		int xfrom = movefrom / 10 -1;
		int yfrom = movefrom % 10 - 1;
		int xto = moveto / 10 - 1;
		int yto = moveto % 10 - 1;
		
		// Change appropriate board elements and decrement redcheckers or blackcheckers if necessary
		board[xfrom][yfrom] = '_';
		board[xto][yto] = whosemove;
		if (Math.abs(xto - xfrom) == 2) {
			board[(xfrom + xto) / 2][(yfrom + yto) / 2] = '_';
			if (whosemove == 'w') {
				whitecheckers--;
			} else {
				blackcheckers--;
			}
		}
	}
	
	/** The method game over checks to see if game is over based on the number of the checkers left 
	 */
	public boolean gameOver() {
		return (whitecheckers == 0 || blackcheckers == 0);
	}
	
	
}
