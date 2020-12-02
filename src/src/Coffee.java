package src;

public class Coffee extends HotDrink {

	@Override
	public String name() {
		return "Coffee";
	}

	@Override
	public float price() {
		return 3.49f;
	}

}