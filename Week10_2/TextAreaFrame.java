import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program shows a frame with a text area that displays
   the growth of an investment. 
*/
public class TextAreaFrame extends JFrame implements ActionListener
{  
   private BankAccount account;
   private JTextArea textArea;
   private JTextField rateField;

   // Default interest rate and initial balance of the bank account
   private static final int DEFAULT_RATE = 10;
   private static final int INITIAL_BALANCE = 1000;

   // Dimensions of the frame
   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 200;

   // Dimensions of the text area for displaying the results
   private final int AREA_ROWS = 10;
   private final int AREA_COLUMNS = 30;

    // Width of the text field for input of the interest rate
   private final int FIELD_WIDTH = 10;

   public TextAreaFrame()
   {  
      // Initialise the bank account to which interest is added
      account = new BankAccount(INITIAL_BALANCE);

      JPanel northPanel = addNorthPanel();
      JScrollPane scrollPane = addScrollPane();
     
      add(northPanel, BorderLayout.NORTH);
      add(scrollPane, BorderLayout.CENTER);
      setTitle("Compound interest calculator");
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   public JPanel addNorthPanel()
   {
      JPanel northPanel = new JPanel();
      // The label and text field for entering the interest rate
      JLabel rateLabel = new JLabel("Interest Rate: ");

      rateField = new JTextField(FIELD_WIDTH);
      rateField.setText("" + DEFAULT_RATE);

      // The button to trigger the calculation
      JButton calculateButton = new JButton("Add Interest");
      calculateButton.addActionListener(this);

      // The panel that holds the input components
      northPanel.add(rateLabel);
      northPanel.add(rateField);
      northPanel.add(calculateButton);
      return northPanel;
   }

   public JScrollPane addScrollPane()
   {
     // Initialise the text area for storing the interest additions
     textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
     textArea.setEditable(false);
     textArea.setText(account.showBalance());
     JScrollPane scrollPane = new JScrollPane(textArea);
     return scrollPane;
   }

   public void actionPerformed(ActionEvent event)
   {
      int rate = Integer.parseInt(rateField.getText().trim());
      account.addInterest(rate);
      textArea.append(account.showBalance());
   }
}
