import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * Class for the Solution of the ActionLisener exercises
 * See other classes for keyboard listeners etc
 */
public class Week8LabSolution extends JFrame implements ActionListener{
	private Mono mono;
	private JTextArea inputArea,outputArea;
	private JTextField keyword;
	private JButton encodeButton,decodeButton;
	public Week8LabSolution() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,500);
		
		setupFrame();
		
		encodeButton.addActionListener(this);
		decodeButton.addActionListener(this);
		
		keyword.addActionListener(this);
		
		/*
		 * Following lines should be uncommented for the 
		 * bit of the exercise that toggles the enabled
		 * status of the buttons 
		 */
//		encodeButton.setEnabled(false);
//		decodeButton.setEnabled(false);

		this.setVisible(true);
	}
	private void setupFrame() {
		/* 
		 * Main panel holds all the components
		 * Grid layout is a fast layout for making things 
		 * that don't look too terrible
		 * here we're saying there are 7 rows and 1 column
		 */
		JPanel mainPanel = new JPanel(new GridLayout(7,1));
		// User will type input text here
		inputArea = new JTextArea(3,200);
		// and output will appear here
		outputArea = new JTextArea(3,200);
		// user will enter keyword in here
		/*
		 * Keywords must be capitals and 
		 * not use any letter more than once
		 * they must also only use the letters A to Z
		 */
		keyword = new JTextField(20);
		mainPanel.add(new JLabel("Keyword (caps only)"));
		mainPanel.add(keyword);
		mainPanel.add(new JLabel("Input text:"));
		mainPanel.add(inputArea);
		mainPanel.add(new JLabel("Output text:"));
		mainPanel.add(outputArea);
		
		/*
		 * make the buttons - they will go in their own
		 * panel in the last grid component
		 * we need the panel to have two things in one place
		 */
		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel);
		encodeButton = new JButton("Encode");
		decodeButton = new JButton("Decode");
		buttonPanel.add(encodeButton);
		buttonPanel.add(decodeButton);
		
		this.add(mainPanel,BorderLayout.CENTER);

	}
	
	// Methods called by actionPerformed
	public void doEncoding() {
		String key = keyword.getText();
		mono = new Mono(key);
		String inputText = inputArea.getText();
		String output = mono.encode(inputText);
		outputArea.setText(output);
	}
	public void doDecoding() {
		String key = keyword.getText();
		mono = new Mono(key);
		String inputText = inputArea.getText();
		String output = mono.decode(inputText);
		outputArea.setText(output);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == encodeButton) {
			doEncoding();
		}else if(e.getSource() == decodeButton) {
			doDecoding();
		}else if(e.getSource() == keyword) {
			
			/*
			 * This code below can be uncommented to 
			 * toggle the enabled status of the buttons
			 * depending on the validity of the 
			 * keyword
			 */
			
//			String key = keyword.getText();
//			if(Mono.checkKeyword(key)) {
//				encodeButton.setEnabled(true);
//				decodeButton.setEnabled(true);
//				doEncoding();
//			} else {
//				encodeButton.setEnabled(false);
//				decodeButton.setEnabled(false);
//				outputArea.setText("");
//			}
		}
		
	}
	
	public static void main(String[] args) {
		new Week8LabSolution();

	}
	

}
