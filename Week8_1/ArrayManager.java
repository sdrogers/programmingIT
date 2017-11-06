/*
 * Demonstrates 2D arrays and event handling
 **/
import javax.swing.*;
import java.awt.event.*;

public class ArrayManager
{
	// define size of grid to play on, i.e. SIZE rows and SIZE cols
	final int SIZE=3;
	
	// 2D array to store the array entry information
	ArrayEntry [][] ticTacToeArray;
	
	// instantiates grid
	public ArrayManager()
	{
		ticTacToeArray = new ArrayEntry[SIZE][SIZE];
	}
	
	// creates grid entries and returns 1D list of buttons
	public JButton[] createGrid() 
	{
		// create list in which to store buttons for return
		JButton[] buttonList = new JButton[SIZE*SIZE];
		int buttonNum=0;
		for (int rowNum=0; rowNum < SIZE; rowNum++)
			for (int colNum=0; colNum < SIZE; colNum++)
			{
				ArrayEntry arrayEntry = new ArrayEntry();
				ticTacToeArray[rowNum][colNum] = arrayEntry;
				JButton button = arrayEntry.getButton();
				buttonList[buttonNum]=button;
				buttonNum++;
			}
		return buttonList;
	}
	
	// find out which button was pressed
	public ArrayEntry findWhichButton(ActionEvent e)
	{
		for (int rowNum=0; rowNum < SIZE; rowNum++)
			for (int colNum=0; colNum < SIZE; colNum++)
			{
				ArrayEntry arrayEntry = ticTacToeArray[rowNum][colNum];
				if (e.getSource()== arrayEntry.getButton())
					return arrayEntry;
			}
		// will not reach here
		return null;
	}
	
	// find out if a player won on a horizontal
	public boolean horizWinner(char player)
	{
		boolean winner = false;
		for (int rowNum=0; rowNum < SIZE; rowNum++)
		{       boolean rowWinner = true;
			for (int colNum=0; colNum < SIZE; colNum++)
				rowWinner = rowWinner & (ticTacToeArray[rowNum][colNum].getPlayer()==player);
			winner = winner | rowWinner;
		}
		return winner;
	}
	
	// find out if a player won on a vertical
	public boolean vertWinner(char player)
	{
		boolean winner = false;
		for (int colNum=0; colNum < SIZE; colNum++)
		{       boolean colWinner = true;
			for (int rowNum=0; rowNum < SIZE; rowNum++)
				colWinner = colWinner & (ticTacToeArray[rowNum][colNum].getPlayer()==player);
			winner = winner | colWinner;
		}
		return winner;
	}
	
	// find out if a player won on a diagonal
	public boolean diagWinner(char player)
	{
		// try out top left to bottom right
		boolean diag1Winner = true;
		for (int diagNum=0; diagNum < SIZE; diagNum++)
			diag1Winner = diag1Winner & (ticTacToeArray[diagNum][diagNum].getPlayer()==player);
		
		// try out bottom left to top right
		boolean diag2Winner = true;
		for (int diagNum=0; diagNum < SIZE; diagNum++)
			diag2Winner = diag2Winner & (ticTacToeArray[diagNum][SIZE-diagNum-1].getPlayer()==player);
		return diag1Winner | diag2Winner;
	}
	
//	disable all buttons (if a player wins)
	public void disableButtons()
	{
		for (int rowNum=0; rowNum < SIZE; rowNum++)
			for (int colNum=0; colNum < SIZE; colNum++)
			{
				ArrayEntry arrayEntry = ticTacToeArray[rowNum][colNum];
				JButton button = arrayEntry.getButton();
				button.setEnabled(false);
			}
	}
}
