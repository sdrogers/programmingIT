import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   A component that shows a colored rectangle.
*/
public class ColoredRectangleComponent extends JComponent
{  
   private Color fillColor;
   private final double PROPORTION = 0.75;
   
   /**
      Constructs a component that shows a colored rectangle.
      @param aColor the fill color for the rectangle
   */
   public ColoredRectangleComponent(Color aColor)
   {  
      fillColor = aColor;
   }
   
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      // Select color into graphics context
   
      g2.setColor(fillColor);
      
      // Construct and fill a rectangle whose center is
      // the center of the window
      int topLeftX = (int) (getWidth()*(1-PROPORTION)) / 2;
      int topLeftY = (int) (getHeight()*(1-PROPORTION)) / 2;
      int width = (int) (getWidth()*PROPORTION);
      int height = (int) (getHeight()*PROPORTION);

      Rectangle rectangle = new Rectangle(topLeftX, topLeftY, width, height);
      g2.fill(rectangle);
   }
}
