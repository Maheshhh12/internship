import java.util.*;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            playTicTacToe();
            System.out.print("Do you want to play again? (y/n): ");
        } while (sc.next().equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        sc.close();
    }

    private static void playTicTacToe() {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        int moves = 0;

        while (true) {
            displayBoard(board);
            char currentPlayer = (moves % 2 == 0) ? 'X' : 'O';

            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = getUserInput("Enter row (1-3): ", 1, 3) - 1;
            int col = getUserInput("Enter column (1-3): ", 1, 3) - 1;

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                moves++;

                if (checkWin(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (moves == 9) {
                    displayBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }
            } else {
                System.out.println("Cell already occupied. Try again.");
            }
        }
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static int getUserInput(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // Consume the invalid input
            }
        }

        return input;
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
