//modification of FilledPanel to allow for 3 colours

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TripleFilledPanel extends JPanel{

	public TripleFilledPanel(int nBorder1, int wBorder1, int sBorder1, int eBorder1,
			int nBorder2, int wBorder2, int sBorder2, int eBorder2,
			Color borderColor, Color fillColor1, Color fillColor2) {
		this.setLayout(new BorderLayout());
		this.setBackground(borderColor);
		Border emptyBorder1  = BorderFactory.createEmptyBorder(nBorder1,wBorder1,sBorder1,eBorder1);
		Border emptyBorder2  = BorderFactory.createEmptyBorder(nBorder2,wBorder2,sBorder2,eBorder2);
		
		this.setBorder(emptyBorder1);
		JPanel midPanel = new JPanel(new BorderLayout());
		midPanel.setBackground(fillColor1);
		midPanel.setBorder(emptyBorder2);
		
		JPanel innerPanel =  new JPanel();
		innerPanel.setBackground(fillColor2);
		
		midPanel.add(innerPanel);
		this.add(midPanel);
	}

}
