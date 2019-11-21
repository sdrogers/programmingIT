package lab_swingEvents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class FortuneTeller1 extends JFrame implements ActionListener {
	private FortunePanel1 mainPanel;
	private String[] fortuneArray = new String[100];
	Random rand = new Random();

	public FortuneTeller1() {
		setSize(300, 300);
		setLocation(20, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new FortunePanel1(this);
		add(mainPanel);
		readStrings(fortuneArray,"/Users/alice/javaFiles/progIT/progIT/src/lab_swingEvents/fortunes");
		
	}
	
	public void actionPerformed(ActionEvent e) {
		int n = nonNull(fortuneArray);
		

		// Obtain a number between [0 - 49].
		int guess = rand.nextInt(n);
		//System.out.println(guess);
		mainPanel.updateText(fortuneArray[guess]);
		
		
	}

	public static void main(String[] args) {
		FortuneTeller1 gui = new FortuneTeller1();
		gui.setVisible(true);

	}

	// helper method - read lines from fileName into an array a
	public static void readStrings(String[] a, String fileName) {
		FileReader fReader = null;
		try {
			fReader = new FileReader(fileName);
			Scanner s = new Scanner(fReader);
			int pos = 0;
			while (s.hasNextLine()) {
				String line = s.nextLine();
				a[pos] = line;
				pos++;
			}
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	//helper method: calculate how many non-null elements in an array
	public static int nonNull(String[] a){
		int i = 0;
		while(a[i]!=null) i++;
		return i;
	}
	
	

}
