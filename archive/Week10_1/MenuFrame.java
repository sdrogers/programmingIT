import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This frame has a menu with commands to change the font 
   of a text sample.
*/
public class MenuFrame extends JFrame implements ActionListener
{   
   private JLabel sampleField;
   private String facename;
   private int fontstyle;
   private int fontsize;
   private JMenuItem exitMenuItem;
   private JMenuItem serifMenuItem;
   private JMenuItem sansSerifMenuItem;
   private JMenuItem monospacedMenuItem;
   private JMenuItem smallerMenuItem;
   private JMenuItem largerMenuItem;
   private JMenuItem plainMenuItem;
   private JMenuItem boldMenuItem;
   private JMenuItem italicMenuItem;
   private JMenuItem boldItalicMenuItem;
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;

   /**
      Constructs the frame.
   */
   public MenuFrame()
   {  
      // Construct text sample     
      sampleField = new JLabel("Big Java");
      add(sampleField, BorderLayout.CENTER);

      // Construct menu      
      JMenuBar menuBar = new JMenuBar();     
      setJMenuBar(menuBar);
      menuBar.add(createFileMenu());
      menuBar.add(createFontMenu());

      facename = "Serif";
      fontsize = 24;
      fontstyle = Font.PLAIN;

      setSampleFont();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   /**
      Creates the File menu.
      @return the menu
   */
   public JMenu createFileMenu()
   {
      JMenu menu = new JMenu("File");
      exitMenuItem = new JMenuItem("Exit");      
      exitMenuItem.addActionListener(this);
      menu.add(exitMenuItem);
      return menu;
   }

   /**
      Creates the Font menu.
      @return the menu
   */
   public JMenu createFontMenu()
   {
      JMenu menu = new JMenu("Font");
      menu.add(createFaceMenu());
      menu.add(createSizeMenu());
      menu.add(createStyleMenu());
      return menu;
   }  

   /**
      Creates the Face submenu.
      @return the menu
   */
   public JMenu createFaceMenu()
   {
      JMenu menu = new JMenu("Face");
      serifMenuItem = new JMenuItem("Serif");
      serifMenuItem.addActionListener(this);
      menu.add(serifMenuItem);
      sansSerifMenuItem = new JMenuItem("SansSerif");
      sansSerifMenuItem.addActionListener(this);
      menu.add(sansSerifMenuItem);
      monospacedMenuItem = new JMenuItem("Monospaced");
      monospacedMenuItem.addActionListener(this);
      menu.add(monospacedMenuItem);
      return menu;
   }

   /**
      Creates the Size submenu.
      @return the menu
   */
   public JMenu createSizeMenu()
   {
      JMenu menu = new JMenu("Size");
      smallerMenuItem = new JMenuItem("Smaller");
      smallerMenuItem.addActionListener(this);
      menu.add(smallerMenuItem);
      largerMenuItem = new JMenuItem("Larger");
      largerMenuItem.addActionListener(this);
      menu.add(largerMenuItem);
      return menu;
   }  

   /**
      Creates the Style submenu.
      @return the menu
   */
   public JMenu createStyleMenu()
   {
      JMenu menu = new JMenu("Style");
      plainMenuItem = new JMenuItem("Plain");
      plainMenuItem.addActionListener(this);
      menu.add(plainMenuItem);
      boldMenuItem = new JMenuItem("Bold");
      boldMenuItem.addActionListener(this);
      menu.add(boldMenuItem);
      italicMenuItem = new JMenuItem("Italic");
      italicMenuItem.addActionListener(this);
      menu.add(italicMenuItem);
      boldItalicMenuItem = new JMenuItem("Bold Italic");
      boldItalicMenuItem.addActionListener(this);
      menu.add(boldItalicMenuItem);
      return menu;
   }  

   public void actionPerformed(ActionEvent e)
   {
      JMenuItem choice = (JMenuItem) e.getSource();
      if (choice == exitMenuItem)
	  System.exit(0);
      else if (choice == serifMenuItem)
	  facename = "Serif";
      else if (choice == sansSerifMenuItem)
	  facename = "SansSerif";
      else if (choice == monospacedMenuItem)
	  facename = "Monospaced";
      else if (choice == smallerMenuItem)
          fontsize-=5;
      else if (choice == largerMenuItem)
          fontsize+=5;
      else if (choice == plainMenuItem)
          fontstyle = Font.PLAIN;
      else if (choice == boldMenuItem)
          fontstyle = Font.BOLD;
      else if (choice == italicMenuItem)
          fontstyle = Font.ITALIC;
      else if (choice == boldItalicMenuItem)
          fontstyle = Font.BOLD + Font.ITALIC;
      setSampleFont();
   }

   /**
      Sets the font of the text sample.
   */
   public void setSampleFont()
   { 
      Font f = new Font(facename, fontstyle, fontsize);
      sampleField.setFont(f);
      sampleField.repaint();
   }
}
