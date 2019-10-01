import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableFrame extends JFrame 
{
   private static final int FRAME_WIDTH = 1200;
   private static final int FRAME_HEIGHT = 300;
   private static final int TABLE_ROWS = 10;
   private static final int TABLE_COLS = 6;
   private static final int FONT_SIZE = 12;

   public JTableFrame()
   {
      this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      this.setTitle("JTable viewer");

      //column headings
      String [] headings = {"n", "n^2", "n^3", "2^n", "3^n", "n!"};	
      String [][] table = new String[TABLE_ROWS][TABLE_COLS];

      for (int i=0; i<TABLE_ROWS; i++)
      {
         int j=(i+1)*TABLE_ROWS;
         table[i][0] = ""+j;
         table[i][1] = ""+(int) Math.pow(j,2);
         table[i][2] = ""+(int) Math.pow(j,3);
         table[i][3] = ""+Math.pow(2,j);
         table[i][4] = ""+Math.pow(3,j);
         table[i][5] = ""+factorial(j);
      }
      
      //create JTable with this array and headings
      JTable tableList = new JTable(table, headings);
      tableList.setFont(new Font("Courier New", Font.PLAIN, FONT_SIZE));
      //add table to scrollpane
      JScrollPane scrollpane = new JScrollPane(tableList);
      add(scrollpane, BorderLayout.CENTER);
   }

   public double factorial (int n)
   {
       double f = 1.0;
       for (int i=2; i<=n; i++)
	   f *= i;
       return f;
   }
}
