import java.awt.*;
import javax.swing.*;

// demonstrate a JFileChooser

public class JFileChooserDemo {

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 200;
   private static final int X_LOCATION = 100;
   private static final int Y_LOCATION = 100;

   public static void main(String[] args)
   {  
       // construct a simple frame
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setLocation(X_LOCATION, Y_LOCATION);
      frame.setTitle("JFileChoose demo");

      JLabel commandLabel = new JLabel("Choose a file");
      JLabel resultLabel = new JLabel("");
      frame.add(commandLabel, BorderLayout.NORTH);
      frame.add(resultLabel, BorderLayout.CENTER);
      frame.setVisible(true);

      // open a JFileChooser object
      JFileChooser chooser = new JFileChooser();
      int returnVal = chooser.showOpenDialog(frame);
  
      // if file chosen, confirm the details
      if (returnVal == JFileChooser.APPROVE_OPTION)
         resultLabel.setText("You chose to open this file: " +
			chooser.getSelectedFile().getName());
      else
	 resultLabel.setText("You did not choose a file");
   }
}
