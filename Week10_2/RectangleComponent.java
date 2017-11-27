import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
   This component lets the user move a rectangle by clicking the mouse.
 */
public class RectangleComponent extends JComponent implements MouseListener
{  
	private Rectangle box;
	private static final int BOX_X = 100;
	private static final int BOX_Y = 100;
	private static final int BOX_WIDTH = 20;
	private static final int BOX_HEIGHT = 30;

	public RectangleComponent()
	{  
		// The rectangle that the paint method draws
		box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
		addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GREEN);
		g2.fill(box);
		g2.setColor(Color.BLACK);
		g2.draw(box);
	}

	public void mousePressed(MouseEvent event)
	{  
		int x = event.getX();
		int y = event.getY();
		box.setLocation(x, y);
		repaint(); 
	}

	// Do-nothing methods
	public void mouseReleased(MouseEvent event) {}
	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {
		int x = (int) box.getX();
		int y = (int) box.getY();
		x += 20;
		y += 10;
		box.setLocation(x,y);
		repaint();
		
	}
	public void mouseExited(MouseEvent event) {}
} 
