import javax.swing.*;

// Constructs a simple frame with a single exit button
// Disables normal exit button on top right of window

public class CloseDemoViewer {
   public static void main(String[] args)
   {  
      // construct a simple frame
      CloseDemo frame = new CloseDemo();
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      frame.setVisible(true);
   }
}
