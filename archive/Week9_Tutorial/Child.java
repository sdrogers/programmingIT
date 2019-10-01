
public class Child implements Comparable<Child>{

	@Override
	public int compareTo(Child o) {
		if(this.age < o.getAge()) {
			return -1;
		}else if(this.age == o.getAge()) {
			if(this.weight < o.getweight()) {
				return -1;
			}else if(this.weight > o.getWeight()) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 1;
		}
	}
	
	

}
