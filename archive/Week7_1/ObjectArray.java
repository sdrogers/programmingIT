
public class ObjectArray {
	public static void main(String[] args) {
		Pet [] pArray = new Pet[3];
		Pet cat = new Pet("bill");
		pArray[0] = cat;
		pArray[1] = new Pet("Clive");
		pArray[2] = pArray[0];
		for(Pet p: pArray) {
			System.out.println(p.getName());
		}
	}
}
