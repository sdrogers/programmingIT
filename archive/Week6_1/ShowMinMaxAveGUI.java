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
