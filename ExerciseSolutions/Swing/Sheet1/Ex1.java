package swingExercises;
// example to reproduce the BorderLayout illustration
// in the slides

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex1 extends JFrame {

	public Ex1() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		
		this.add(new JLabel("NORTH"), BorderLayout.NORTH);
		this.add(new JLabel("EAST"), BorderLayout.EAST);
		this.add(new JLabel("SOUTH"), BorderLayout.SOUTH);
		this.add(new JLabel("WEST"), BorderLayout.WEST);
		this.add(new JLabel("CENTER"), BorderLayout.CENTER);
	}

	/*
	 * Main method -- creates the BorderFrame object
	 */
	public static void main(String[] args) {

		Ex1 gui = new Ex1();
		gui.setVisible(true);
	}
}
