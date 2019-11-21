import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * Advanced version that does everything in real time...
 */
public class Week8LabSolution2 extends JFrame implements ActionListener, KeyListener {
	private Mono mono;
	private JTextArea inputArea, outputArea;
	private JTextField keyword;
	private JRadioButton encodeButton, decodeButton;
	private ButtonGroup radioGroup; // Need this so that only one radio button can be selected at once

	public Week8LabSolution2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 500);

		setupFrame();

		encodeButton.addActionListener(this);
		decodeButton.addActionListener(this);
		encodeButton.setSelected(true);
		keyword.addActionListener(this);
		keyword.addKeyListener(this);
		inputArea.addKeyListener(this);

		this.setVisible(true);
	}

	private void setupFrame() {
		/*
		 * Main panel holds all the components Grid layout is a fast layout for making
		 * things that don't look too terrible here we're saying there are 7 rows and 1
		 * column
		 */
		JPanel mainPanel = new JPanel(new GridLayout(7, 1));
		// User will type input text here
		inputArea = new JTextArea(3, 200);
		// and output will appear here
		outputArea = new JTextArea(3, 200);
		// user will enter keyword in here
		/*
		 * Keywords must be capitals and not use any letter more than once they must
		 * also only use the letters A to Z
		 */
		keyword = new JTextField(20);
		mainPanel.add(new JLabel("Keyword (caps only)"));
		mainPanel.add(keyword);
		mainPanel.add(new JLabel("Input text:"));
		mainPanel.add(inputArea);
		mainPanel.add(new JLabel("Output text:"));
		mainPanel.add(outputArea);

		/*
		 * make the buttons - they will go in their own panel in the last grid component
		 * we need the panel to have two things in one place
		 */
		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel);
		encodeButton = new JRadioButton("Encode");
		decodeButton = new JRadioButton("Decode");
		radioGroup = new ButtonGroup();
		radioGroup.add(encodeButton);
		radioGroup.add(decodeButton);
		buttonPanel.add(encodeButton);
		buttonPanel.add(decodeButton);

		this.add(mainPanel, BorderLayout.CENTER);

	}

	/*
	 * Keyboard stuff for advanced bits
	 */
	public void keyReleased(KeyEvent e) {
		// if a key is released in either keyword or inutArea, do something
		codeOrDecode();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}

	/*
	 * Rationalise this stuff into some useful methods
	 */
	public void codeOrDecode() {
		String key = keyword.getText();

		if (Mono.checkKeyword(key)) {
			if (encodeButton.isSelected()) {
				doEncoding();
			} else {
				doDecoding();
			}
		} else {
			outputArea.setText("");
		}

	}

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

	/*
	 *  We still need this so that things happen
	 * 	when the user toggles between encode and decode
	 */
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == encodeButton) {
			doEncoding();
		} else if (e.getSource() == decodeButton) {
			doDecoding();
		} 
	}

	public static void main(String[] args) {
		new Week8LabSolution2();

	}

}
