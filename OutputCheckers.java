package checkersgame;

public class OutputCheckers extends InputCheckers{
	/** This method returns which player is the winner */
	public String winnerIs() {
		if (blackcheckers == 0) {
			return "The winner is Player 1";
		}
		else {
			return "The winner is Player 2";
		}
	}
	
	
	/** The method printBoard prints out the checker board
	 * by looping through all board positions in apprioate order
	 */
	public void printBoard() {
		int x, y;
		System.out.println("   1  2  3  4  5  6  7  8  x ");
		for (x = 0; x < SIZE; x++) {
			System.out.print((x + 1) + "  ");
			for (y = 0; y < SIZE; y++) {
				System.out.print(board[y][x] + "  ");
			}
			System.out.println("\n");
		}
		System.out.println("y");
	}

}
