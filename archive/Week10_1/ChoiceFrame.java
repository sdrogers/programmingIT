import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
   This frame contains a text field and a control panel
   to change the font of the text.
*/
public class ChoiceFrame extends JFrame implements ActionListener
{   
   private JLabel sampleField;
   private JCheckBox italicCheckBox;
   private JCheckBox boldCheckBox;
   private JRadioButton smallButton;
   private JRadioButton mediumButton;
   private JRadioButton largeButton;
   private JComboBox facenameCombo;
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;
   private final int SMALL_SIZE = 24;
   private final int MEDIUM_SIZE = 36;
   private final int LARGE_SIZE = 48;

   /**
      Constructs the frame.
   */
   public ChoiceFrame()
   {  
      // Construct text sample
      sampleField = new JLabel("Big Java");
      add(sampleField, BorderLayout.CENTER);

      createControlPanel();
      setSampleFont();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   /**
      Creates the control panel to change the font.
   */
   public void createControlPanel()
   {
      JPanel facenamePanel = createComboBox();
      JPanel styleGroupPanel = createCheckBoxes();
      JPanel sizeGroupPanel = createRadioButtons();

      // Line up component panels	

      JPanel controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(3, 1));
      controlPanel.add(facenamePanel);
      controlPanel.add(styleGroupPanel);
      controlPanel.add(sizeGroupPanel);

      // Add panels to content pane

      add(controlPanel, BorderLayout.SOUTH);
   }

   /**
      Creates the combo box with the font style choices.
      @return the panel containing the combo box
   */
   public JPanel createComboBox()
   {
      facenameCombo = new JComboBox();
      facenameCombo.addItem("Serif");
      facenameCombo.addItem("SansSerif");
      facenameCombo.addItem("Monospaced");
      facenameCombo.setSelectedItem("SansSerif");

      facenameCombo.addActionListener(this);

      JPanel panel = new JPanel();
      panel.add(facenameCombo);
      return panel;
   }

   /**
      Creates the check boxes for selecting bold and italic styles.
      @return the panel containing the check boxes
   */
   public JPanel createCheckBoxes()
   {
      italicCheckBox = new JCheckBox("Italic");
      italicCheckBox.addActionListener(this);

      boldCheckBox = new JCheckBox("Bold");
      boldCheckBox.addActionListener(this);

      JPanel panel = new JPanel();
      panel.add(italicCheckBox);
      panel.add(boldCheckBox);
      panel.setBorder
         (new TitledBorder(new EtchedBorder(), "Style"));

      return panel;
   }

   /**
      Creates the radio buttons to select the font size
      @return the panel containing the radio buttons
   */
   public JPanel createRadioButtons()
   {
      smallButton = new JRadioButton("Small");
      smallButton.addActionListener(this);

      mediumButton = new JRadioButton("Medium");
      mediumButton.addActionListener(this);

      largeButton = new JRadioButton("Large");
      largeButton.addActionListener(this);
      largeButton.setSelected(true);

      // Add radio buttons to button group

      ButtonGroup group = new ButtonGroup();
      group.add(smallButton);
      group.add(mediumButton);
      group.add(largeButton);

      JPanel panel = new JPanel();
      panel.add(smallButton);
      panel.add(mediumButton);
      panel.add(largeButton);
      panel.setBorder
            (new TitledBorder(new EtchedBorder(), "Size"));

      return panel;
   }

   /**
      Gets user choice for font name, style, and size
      and sets the font of the text sample.
   */
   public void actionPerformed(ActionEvent event)
   {
      setSampleFont();
   }

   public void setSampleFont()
   {
      // Get font name   
      String facename 
            = (String) facenameCombo.getSelectedItem();
      
      // Get font style
      int style = 0;
      if (italicCheckBox.isSelected()) 
         style += Font.ITALIC;   // +=1
      if (boldCheckBox.isSelected()) 
         style += Font.BOLD;     // +=2
         
      // Get font size   
      int size = 0;

      if (smallButton.isSelected()) 
         size = SMALL_SIZE;
      else if (mediumButton.isSelected()) 
         size = MEDIUM_SIZE;
      else if (largeButton.isSelected()) 
         size = LARGE_SIZE;
         
      // Set font of text field
      sampleField.setFont(new Font(facename, style, size));      
      sampleField.repaint();
   }
}
