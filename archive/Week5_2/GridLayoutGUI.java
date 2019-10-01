/**
 A simple class to show a single frame
*/

//import java classes for GUI components
import javax.swing.*;
import java.awt.*;

public class GridLayoutGUI extends JFrame
{  
   public GridLayoutGUI() {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(280,210);
      setLocation(100,100);
      setTitle("JFrame with Grid Layout");
      setLayout(new GridLayout(4,3));
      for (int i=1; i<=4; i++)
         for (int j=1; j<=3; j++) {
            JLabel label = new JLabel("This is cell "+i+","+j);
            this.add(label);
         }
   }
}
