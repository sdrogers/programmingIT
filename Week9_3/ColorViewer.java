import java.awt.*;
import javax.swing.*;

public class ColorViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      String input;

      // Ask the user for red, green, blue values
   
      input = JOptionPane.showInputDialog("red:");
      float red = Float.parseFloat(input);
      
      input = JOptionPane.showInputDialog("green:");
      float green = Float.parseFloat(input);
      
      input = JOptionPane.showInputDialog("blue:");
      float blue = Float.parseFloat(input);

      Color fillColor = new Color(red, green, blue);
      ColoredRectangleComponent component 
            = new ColoredRectangleComponent(fillColor);
      frame.add(component);

      frame.setVisible(true);
   }
}
