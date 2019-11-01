package swingExercises;

import javax.swing.JFrame;

// Ex7
// now all the work is done in the BorderPanel object!


public class Ex7 extends JFrame {
	public Ex7() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderPanel myPanel = new BorderPanel();	
		this.add(myPanel);	
	}

	/*
	 * Main method -- creates the BorderFrame object
	 */
	public static void main(String[] args) {

		Ex7 gui = new Ex7();
		gui.setVisible(true);
	}
}
