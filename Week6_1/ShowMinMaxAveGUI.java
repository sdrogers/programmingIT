<<<<<<< HEAD
public class ShowMinMaxAveGUI
{  
	public static void main(String [] args)
	{
		MinMaxAveModel model = new MinMaxAveModel();
		MinMaxAveController controller = new MinMaxAveController(model);
		MinMaxAveView view = new MinMaxAveView(model, controller);
		controller.setView(view);
		// Alternatively, comment out previous two lines..
		
		view.setVisible(true);
	}
}
=======
public class ShowMinMaxAveGUI
{  
	public static void main(String [] args)
	{
		MinMaxAveModel model = new MinMaxAveModel();
		MinMaxAveController controller = new MinMaxAveController(model);
		MinMaxAveView view = new MinMaxAveView(model, controller);
		controller.setView(view);
		view.setVisible(true);
	}
}
>>>>>>> pr/4
