/**
 * Demonstrates 2D arrays and event handling
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame implements ActionListener
{
	// define size of grid to play on, i.e. SIZE rows and SIZE cols
	final int SIZE=3;
	// instance variables to store the components 
	JPanel top, middle, bottom;
	JLabel topLabel, bottomLabel;
	// variable to store whose turn it is
	char turn='O';
	// variable to store how many rounds have been played
	int numRounds = 0;
	
	// class to manage the array entries
	ArrayManager arrayManager;
	
	// the constructor adds all the components to the frame
	public TicTacToeGUI()
	{
		// set size according to number of rows and columns
		this.setSize(100*SIZE,100*SIZE);

		this.setTitle("Tic Tac Toe");

		// when the user clicks on the close button, the program exits
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set layout
		this.layoutComponents();
	}
	
	// construct GUI
	private void layoutComponents()
	{
		//top panel is red and displays the title
		top = new JPanel();
		topLabel = new JLabel("Tic Tac Toe");
		top.add(topLabel);
		top.setBackground(Color.red);
		
		//add the top panel to the content pane
		add(top,BorderLayout.NORTH);
		
		//middle panel contains SIZE x SIZE buttons
		middle = new JPanel();
		middle.setLayout(new GridLayout(SIZE,SIZE));
		
		// create grid entries and obtain list of buttons in 1D array
		arrayManager = new ArrayManager();
		JButton [] buttonList = arrayManager.createGrid();
		
		// add buttons in buttonList to middle panel and ActionListener
		for (JButton button : buttonList)
		{
			button.addActionListener(this);
			middle.add(button);
		}
		//add the center panel to the content pane
		add(middle,BorderLayout.CENTER);
		
		//bottom panel displays whose turn it is
		bottom = new JPanel();
		bottomLabel = new JLabel("Player "+turn+"'s turn");
		bottom.add(bottomLabel);
		//add the bottom panel to the content pane
		add(bottom,BorderLayout.SOUTH);
	}
	
	//handle button events
	public void actionPerformed(ActionEvent e)
	{
		// find out which button was pressed
		ArrayEntry arrayEntry = arrayManager.findWhichButton(e);
		JButton button = arrayEntry.getButton();
		// update text on button to show who clicked there
		button.setText(""+turn);
		// disable button
		button.setEnabled(false);
		arrayEntry.setPlayer(turn);
		
		// find out if player has won on a horizontal
		if (arrayManager.horizWinner(turn) || arrayManager.vertWinner(turn) ||
				arrayManager.diagWinner(turn))
		{	bottomLabel.setText("Player "+turn+" wins!");
			arrayManager.disableButtons();
		}
		else
		{	// change turn to other player
			if (turn=='O')
				turn = 'X';
			else
				turn= 'O';
			// increment number of rounds played
			numRounds++;
			if (numRounds < SIZE*SIZE) // prompt next player
				bottomLabel.setText("Player "+turn+"'s turn");
			else // game over without a winner
				bottomLabel.setText("Game over: stalemate.");
		}
	}
}
