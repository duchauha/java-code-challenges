/**
 * 
 */
package tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author duchauha
 *
 */
public class Board {

	private int[][] board;
	private Queue<Player> nextTurn;
	private int size;
	private Scanner input;
	private int[] rowSum;
	private int[] colSum;
	private int diagonalSum = 0;
	private int reverseDiagSum = 0;
	private int winner;

	public Board(Player[] players, int size) {
		this.size = size;
		board = new int[size][size];
		nextTurn = new LinkedList<>();
		nextTurn.offer(players[0]);
		nextTurn.offer(players[1]);
		rowSum = new int[size];
		colSum = new int[size];
		input = new Scanner(System.in);

	}

	public void startGame() {
		int counter = 0;
		System.out.println("game is started. Board is initialized ");
		printBoard();
		while (true) {
			counter++;
			if (counter == size * size + 1) {
				System.out.println("Match Draw");
				break;
			}

			Player player = nextTurn.poll();
			System.out.println(player.getName() + " please enter a row to give your input ");
			int row = input.nextInt();
			System.out.println(player.getName() + " please enter a col to give your input ");
			int col = input.nextInt();
			int result = makeMove(player, row, col);
			System.out.println("board after the move");
			printBoard();
			if (result == player.getPlaySymbol()) {
				System.out.println("Game is ended." + player.getName() + " is the winner");
				break;
			}
			nextTurn.offer(player);
		}

	}

	private int makeMove(Player player, int row, int col) {
		if (row < 0 || col < 0 || row >= size || col >= size) {
			throw new IllegalArgumentException("Move out of boundary of the board");
		} else if (board[row][col] != 0) {
			throw new IllegalArgumentException("square is already taken");
		} else if (this.winner != 0) {
			throw new IllegalArgumentException("Board is decided");
		} else {
			board[row][col] = player.getPlaySymbol();
			rowSum[row] += player.getPlaySymbol();
			colSum[col] += player.getPlaySymbol();
			if (row == col) {
				diagonalSum += player.getPlaySymbol();
			}
			if (row == size - col - 1) {
				reverseDiagSum += player.getPlaySymbol();
			}
			if (Math.abs(rowSum[row]) == size || Math.abs(colSum[col]) == size || Math.abs(diagonalSum) == size
					|| Math.abs(reverseDiagSum) == size) {
				this.winner = player.getPlaySymbol();
				return this.winner;
			}
		}
		return this.winner;
	}

	public void printBoard() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(" " + board[row][col] + " ");
			}
			System.out.println("");
		}
	}
}
