/**
 Creates a simple GUI to enable a guessing game to be played
*/

public class PlayColouredGame
{
	//instantiates and displays a gameGUI object
	public static void main(String [] args)
	{
		ColouredGameGui gameWindow = new ColouredGameGui();
		gameWindow.setSize(500,200);
		gameWindow.setVisible(true);
	}
}
