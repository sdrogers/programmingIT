import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CloseDemo extends JFrame implements ActionListener 
{
   private static final int FRAME_WIDTH = 220;
   private static final int FRAME_HEIGHT = 70;

   public CloseDemo()
   {  
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setTitle("Press Exit to quit");
      JButton button = new JButton("Exit");
      button.addActionListener(this);
      JPanel panel = new JPanel();
      panel.add(button);
      add(panel);
   }

   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
}
