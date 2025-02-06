import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creates empty board
        char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};

        //This is how you get the integer from the user in the console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");

        //Sets turn to X and runs a loop while there isn't a winner
        boolean isXsTurn = true;
        while (!winner(board)) {
            isXsTurn = anotherTurn(isXsTurn, board, scanner);
        }

        System.out.println("\nWe have a winner!");

    }

    //Runs another turn
    static boolean anotherTurn(boolean isXsTurn, char[] board, Scanner scanner) {
        char xOro;
        System.out.println();

        //If X's turn , print Player 1 and change variable to x
        if (isXsTurn) {
            System.out.println("Player 1 (x) What's your move?");
            xOro = 'x';

            //If O's turn , print Player 2 and change variable to o
        } else {
            System.out.println("Player 2 (o) What's your move?");
            xOro = 'o';
        }
        printBoard(board);

        int move = validateMoveAllowed(board, scanner);

        //Sets the move to te board
        board[move] = xOro;

        //changes to opposing player's turn
        return !isXsTurn;
    }

    //If the move was already played, notify user and ask for another number
    private static int validateMoveAllowed(char[] board, Scanner scanner) {
        int move;
        while (true) {
            move = scanner.nextInt();
            if (board[move] == 'x' || board[move] == 'o') {
                System.out.println();
                System.out.println("Already played. Choose again.");
            } else {
                break;
            }
        }
        return move;
    }


    //Checks if there is a winner, could be x or o
    static boolean winner(char[] board) {
        return winner('x', board) || winner('o', board);
    }

    //Checks if there is a winner
    static boolean winner(char xOro, char[] board) {
        if ((board[0] == xOro && board[1] == xOro && board[2] == xOro) ||
                (board[3] == xOro && board[4] == xOro && board[5] == xOro) ||
                (board[6] == xOro && board[7] == xOro && board[8] == xOro) ||

                (board[0] == xOro && board[3] == xOro && board[6] == xOro) ||
                (board[1] == xOro && board[4] == xOro && board[7] == xOro) ||
                (board[2] == xOro && board[5] == xOro && board[8] == xOro) ||

                (board[0] == xOro && board[4] == xOro && board[8] == xOro) ||
                (board[2] == xOro && board[4] == xOro && board[6] == xOro)) {
            return true;
        }

        return false;
    }


    //Prints out the board
    static void printBoard(char[] board) {
        System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
        System.out.println("-+-+-");
        System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
        System.out.println("-+-+-");
        System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
    }


}
