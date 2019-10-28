public class Part1 {
    public static void main(String[] args) {
        int nRows = 6;
        int nCols = 6;
        int[][] table = new int[nRows][nCols];

        // Create the table
        for(int row = 0;row < nRows; row++) {
            /*
                I solve this by firstly writing a loop to put the zeros in. This is
                not strictly necessary (as the values are zero by default), but helps
                to understand I think.

                Then I add the counting which goes from 1 to 6-row (inclusive). I.e. 
                on row zero it goes to 6, on row 1 to 5, etc.

                Final thing is computing where the 1,2,3,etc should go. If j is counting 1,2,3 etc
                then the 1 goes in (row + 1 - 1), the 2 in (row + 2 - 1), etc
            */
            // Start with row zeros
            for(int j=0;j<row;j++) {
                table[row][j] = 0;
            }
            // Now count
            for(int j=1;j<=nCols-row;j++) {
                table[row][row+j-1] = j;
            }
        }
        printArray(table);
    }
    public static void printArray(int[][] ar) {
        int nRows = ar.length;
        int nCols = ar[0].length;
        for(int i=0;i<nRows;i++) {
            for(int j=0;j<nCols;j++) {
                System.out.print(ar[i][j] + "\t");
            }
            System.out.println();
        }
    }
}