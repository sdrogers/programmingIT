import javax.swing.JFrame;

/**
   This program tests the MenuFrame.
*/
public class MenuFrameViewer
{  
   public static void main(String[] args)
   {  
      MenuFrame frame = new MenuFrame();
      frame.setTitle("Font selector");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);      
   }
}

