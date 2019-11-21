package lab_swingEvents;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FortunePanel extends JPanel {
private JButton button1;
private JTextField text;
	public FortunePanel() {
		this.setLayout(new BorderLayout());
		button1 = new JButton("Tell me my fortune!");
		
	}
	
	public void updateText(String s){
		text.setText(s);
		
	}

}
