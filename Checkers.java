package checkersgame;
import java.io.*;
import java.util.*;

public class Checkers {

	public final static int SIZE = 8;
	public char[][] board;		//Stores the checkerboard, with chars, 'r', 'b', '_'
	public int whitecheckers;
	public int blackcheckers;
	public char whosemove;	//Either 'r' or 'b', for who's move it currently is.
	
	// Constructs default Checkers object, initializing board to starting playing position
	public Checkers() {
		board = new char[SIZE][SIZE];
		whitecheckers = 12;
		blackcheckers = 12;
		whosemove = 'w';
		
		// Intitalize board with all red and black checkers in starting positions.
		int i, j;
		for (i = 0; i < SIZE; i++)
			for (j = 0; j < SIZE; j++) 
				board[i][j] = '_';
		
		for (i = 1; i < SIZE; i+= 2) {
			board[i][1] = 'w';
			board[i][5] = 'b';
			board[i][7] = 'b';
		}
		
		for (i = 0; i < SIZE; i+=2) {
			board[i][0] = 'w';
			board[i][2] = 'w';
			board[i][6] = 'b';
		}
	}

}
