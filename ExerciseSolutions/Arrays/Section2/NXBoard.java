import java.util.Scanner;
public class NXBoard {
    private char[][] board = new char[3][3];
    private int turnNumber = 0;
    private Scanner keyboard = new Scanner(System.in);

    public String toString() {
        String output = "";
        for(int i=0;i<3;i++) {
            String line = "" + board[i][0] + "|" + board[i][1] + "|" + board[i][2] + "\n";
            output += line;
            if(i < 2) {
                output += "-----\n";                
            }
        }
        return output;
    }
    private boolean checkWinner(char x) {
        return false;
    }
    private boolean setChar(int row,int col,char x) {
        if(board[row][col] == ' ') {
            board[row][col] = x;
            return true;
        }else {
            return false;
        }
    }
    private void resetBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                board[i][j] = ' ';
            }
        }
        turnNumber = 0;
    }
    public void playGame() {
        resetBoard();
        while(true) {
            if(turnNumber % 2 == 0) {
                playMove('x');
            }else {
                playMove('o');
            }
            System.out.println(this);
        }
    }
    private int playMove(char player) {
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
                    turnNumber += 1;

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
}