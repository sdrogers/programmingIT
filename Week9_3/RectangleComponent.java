import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;

/**
   A component that draws some shapes and displays a message
*/
public class RectangleComponent extends JComponent
{  
   private Rectangle box;
   private int boxXCoord;
   private int boxYCoord;
   private final int BOX_X = 100;
   private final int BOX_Y = 100;
   private final int BOX_WIDTH = 20;
   private final int BOX_HEIGHT = 30;
   private final int BOX_TRANSLATE_X = 15;
   private final int BOX_TRANSLATE_Y = 25;
   private final int MESSAGE_X = 50;
   private final int MESSAGE_Y = 50;
   private final int ELLIPSE_X = 20;
   private final int ELLIPSE_Y = 300;
   private final int ELLIPSE_WIDTH = 20;
   private final int ELLIPSE_HEIGHT = 30;
   private final int FILL_RECT_X = 250;
   private final int FILL_RECT_Y = 250;
   private final int FILL_RECT_WIDTH = 30;
   private final int FILL_RECT_HEIGHT = 40;
   private final int POINT_FROM_X = 75;
   private final int POINT_FROM_Y = 250;
   private final int POINT_TO_X = 125;
   private final int POINT_TO_Y = 300;
   
   /**
     * Constructor for RectangleComponent object
     */
   public RectangleComponent()
   {
      // The rectangle that the paint method draws
      box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
      boxXCoord = BOX_X;
      boxYCoord = BOX_Y;
   }
 
   /**
    * Updates the display
    * @param g the Graphics object
    */  
   public void paintComponent(Graphics g)
   {  
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;

      // Construct a rectangle and draw it
      box.setLocation(boxXCoord, boxYCoord);
      g2.draw(box);

      // Move rectangle 15 units to the right and 25 units down
      box.translate(BOX_TRANSLATE_X, BOX_TRANSLATE_Y);

      // Draw moved rectangle
      g2.draw(box);

      // Set colour to green and display a message
      g2.setColor(Color.GREEN);
      g2.drawString("Message",MESSAGE_X,MESSAGE_Y);

      // Set colour to yellow and display a filled rectangle
      g2.setColor(Color.YELLOW);
      g2.fillRect(FILL_RECT_X, FILL_RECT_Y, FILL_RECT_WIDTH, FILL_RECT_HEIGHT);

      // Display an ellipse with red outline and blue interior
      Ellipse2D.Double ellipse = new Ellipse2D.Double(ELLIPSE_X, ELLIPSE_Y, ELLIPSE_WIDTH, ELLIPSE_HEIGHT);
      g2.setColor(Color.RED);
      g2.draw(ellipse);
      g2.setColor(Color.BLUE);
      g2.fill(ellipse);

      // Display a line segment
      Point2D.Double from = new Point2D.Double(POINT_FROM_X, POINT_FROM_Y);
      Point2D.Double to = new Point2D.Double(POINT_TO_X, POINT_TO_Y);
      Line2D.Double segment = new Line2D.Double(from, to);
      g2.draw(segment);
   }
   
   /**
    * Moves the rectangle to the given location.
    * @param x the x-position of the new location
    * @param y the y-position of the new location
    */
   public void moveTo(int x, int y)
   {
      boxXCoord = x;
      boxYCoord = y;
   }
}
