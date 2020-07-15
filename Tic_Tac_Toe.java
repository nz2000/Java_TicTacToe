import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tic_Tac_Toe {
	static Scanner in;
	static String[] board;
	static String userid;
	public static void main(final String[] args) {
        in = new Scanner(System.in);
        board = new String[9];
        userid = "X";
        String winner = null;
        BoardMap();
        printBoard();
        System.out.println("Welcome Player, please enter a slot number to place X in:");

        while (winner == null) {
            int numInput;
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (final InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = userid;
				if (userid.equals("X")) {
					userid = "O";
				} else {
					userid = "X";
				}
				printBoard();
				winner = UserInputCheck();
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}

	static String UserInputCheck() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(userid + "'s turn; enter a slot number to place " + userid + " in:");
		return null;
	}

	static void printBoard() {

		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");

		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");

		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");

	}

	static void BoardMap() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
}