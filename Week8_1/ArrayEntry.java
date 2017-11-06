/*
 * Demonstrates 2D arrays and event handling
 **/
import javax.swing.*;

public class ArrayEntry
{
	// player who has clicked on this entry
	// 'O' = player O
	// 'X' = player X
	// '-' = nobody has clicked here yet
	private char player;
	
	// button stored at this array entry
	private JButton button;
	
	// constructor
	public ArrayEntry()
	{
		player = '-';
		button = new JButton();
	}
	
	// return button
	public JButton getButton()
	{
		return button;
	}
	
	// return player
	public char getPlayer()
	{
		return player;
	}
	
        // set player
	public void setPlayer(char c)
	{
		player = c;
	}
}
