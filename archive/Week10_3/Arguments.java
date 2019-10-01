public class Arguments
{
	public static void main(String[] args)
	{
                int len = args.length;
		System.out.print("You entered "+len+" argument");
		if (len==0 || len >1)
		    System.out.print("s");
		System.out.println();
                int index = 0;
		for (String e : args) {
		    System.out.println("Argument "+index+" is \""+e+"\"");
		    index++;
		}
	}
}
