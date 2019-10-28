import java.util.Scanner;
public class NandX { 
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner keyboard = new Scanner(System.in);
        resetBoard(board); // Set all values to space
        printBoard(board); // Print it out
        while(true) { // Loop forever
            // Player 1
            int outcome = play(board,'x',keyboard);
            if(outcome == -1) {
                break;
            }
            printBoard(board);
            // Player 2
            outcome = play(board,'o',keyboard);
            if(outcome == -1) {
                break;
            }
            printBoard(board);
        }
        keyboard.close();
    }
    // Main logic is in here
    /*
        Takes user input (row and column split by space)
        Keeps asking for input until they enter a space that 
        is currently empty *or* they enter something that 
        is not parsable as two ints.
        In the former, the method returns '1' (success). In the latter '-1' (error)
        and the program terminates.
    */
    public static int play(char[][] board,char player, Scanner keyboard) {
        boolean legalMove = false;
        int outcome = -1;
        while(!legalMove) {
            System.out.println("Enter co-ordinates (format: row col):");
            String entry = keyboard.nextLine();
            try {
                String[] tokens = entry.split(" ");
                int row = Integer.parseInt(tokens[0]);
                int col = Integer.parseInt(tokens[1]);
                if(board[row][col] == ' ') {
                    board[row][col] = player;
                    legalMove = true;
                    outcome = 1;
                }
            }catch(Exception e) {
                // e.printStackTrace();
                // If anything goes wrong, game over.
                outcome = -1;
                break;
            }
        }
        return outcome;
    }
    // Method to print board
    public static void printBoard(char[][] board) {
        for(int i=0;i<3;i++) {
            String line = "" + board[i][0] + "|" + board[i][1] + "|" + board[i][2];
            System.out.println(line);
            if(i < 2) {
                System.out.println("-----");                
            }

        }
    }
    // Reset it to blanks
    public static void resetBoard(char[][] board) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                board[i][j] = ' ';
            }
        }
    }
}