package lab_swingEvents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FortuneTeller extends JFrame {
private FortunePanel mainPanel;
	public FortuneTeller() {
		setSize(300,300);
		setLocation(20,20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new FortunePanel();
		add(mainPanel);
	}

	public static void main(String[] args) {
		FortuneTeller gui =  new FortuneTeller();
		gui.setVisible(true);

	}

	
	

}
