//Wallpaper for lab
//uses TripleFilledPanel
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class LabWallpaper extends JFrame {

	public LabWallpaper(){
		final int UNIT = 20;
		this.setLocation(20,20);
		this.setTitle("Wallpaper3");
		this.setSize(30*UNIT, 30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new GridLayout(3,2));
		
		this.add(new TripleFilledPanel(UNIT,UNIT,UNIT,UNIT, UNIT,UNIT,UNIT,UNIT,Color.red,Color.white,Color.blue));
		this.add(new TripleFilledPanel(UNIT,UNIT,UNIT,UNIT, UNIT,UNIT,UNIT,UNIT,Color.white,Color.blue,Color.green));
		this.add(new TripleFilledPanel(UNIT,UNIT,UNIT,UNIT, UNIT,UNIT,UNIT,UNIT,Color.blue,Color.green,Color.yellow));
		this.add(new TripleFilledPanel(UNIT,UNIT,UNIT,UNIT, UNIT,UNIT,UNIT,UNIT,Color.green,Color.yellow,Color.orange));
		this.add(new TripleFilledPanel(UNIT,UNIT,UNIT,UNIT, UNIT,UNIT,UNIT,UNIT,Color.yellow,Color.orange,Color.cyan));
		this.add(new TripleFilledPanel(UNIT,UNIT,UNIT,UNIT, UNIT,UNIT,UNIT,UNIT,Color.orange,Color.cyan,Color.red));	
		
	}
	
	public static void main(String[] args){
		LabWallpaper gui = new LabWallpaper();
		gui.setVisible(true);
	}

}
