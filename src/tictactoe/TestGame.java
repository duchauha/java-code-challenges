/**
 * 
 */
package tictactoe;

import java.util.Scanner;

/**
 * @author duchauha
 *
 */
public class TestGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			Player one = new Player();
			System.out.println("please enter the name of the 1st player");
			one.setName(sc.nextLine());
			one.setPlaySymbol(1);

			Player two = new Player();

			System.out.println("please enter the name of the 2nd player");
			two.setName(sc.nextLine());
			two.setPlaySymbol(-1);

			System.out.println("please enter the size of the board");
			Board board = new Board(new Player[] { one, two }, sc.nextInt());

			board.startGame();
			System.out.println("game is over exiting the game");
			sc.close();
			System.exit(0);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
