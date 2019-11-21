package lab_swingEvents;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FortunePanel1 extends JPanel {
private JButton button1;
private JTextField text;
	public FortunePanel1(ActionListener parent) {
		this.setLayout(new BorderLayout());
		button1 = new JButton("Tell me my fortune!");
		button1.addActionListener(parent);
		this.add(button1, BorderLayout.CENTER);
		text = new JTextField(50);
		this.add(text, BorderLayout.SOUTH);
	}
	
	public void updateText(String s){
		text.setText(s);
		
	}

}
