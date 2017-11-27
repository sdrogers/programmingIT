import javax.swing.JFrame;

/**
   This program tests the ChoiceFrame.
*/
public class ChoiceFrameViewer
{  
   public static void main(String[] args)
   {  
      ChoiceFrame frame = new ChoiceFrame();
      frame.setTitle("Font selector");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);      
   }
}

