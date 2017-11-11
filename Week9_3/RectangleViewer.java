import javax.swing.*;

public class RectangleViewer
{
   public static void main(String[] args)
   {
      // set up a new frame to contain a JComponent
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Two rectangles");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // declare and instantiate a new component and add it to the frame
      RectangleComponent component = new RectangleComponent();
      frame.add(component);

      frame.setVisible(true);

      // ask for x/y co-ordinates to reposition the overlapping rectangles      
      String xcoord = JOptionPane.showInputDialog(null, "Enter x-coordinate");
      String ycoord = JOptionPane.showInputDialog(null, "Enter y-coordinate");
      int x = Integer.parseInt(xcoord);
      int y = Integer.parseInt(ycoord);

      // move the overlapping rectangles and update the display
      component.moveTo(x,y);
      component.repaint();   
   }
}
