import javax.swing.*;

/**
   This program displays a RectangleComponent
*/
public class RectangleComponentViewer
{  
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;

   public static void main(String[] args)
   {        
      JFrame frame = new JFrame();
      RectangleComponent component = new RectangleComponent();
      frame.add(component);
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Rectangle viewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
} 
