package src;

public abstract class HotDrink implements Concessions {

	@Override
	public abstract float price();

	@Override
	public Item item() {
		return new Food();
	}

}
