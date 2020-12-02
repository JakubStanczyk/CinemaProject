package src;

import java.util.ArrayList;
import java.util.List;
public class Meal {
	private List<Concessions> concessions = new ArrayList<Concessions>();
	
	public void addItem(Concessions concession) {
		concessions.add(concession);
	}
	
	public float getCost() {
		float cost = 0.0f;
		
		for (Concessions concession:concessions) {
			cost += concession.price();
		}
		return cost;
	}
}
