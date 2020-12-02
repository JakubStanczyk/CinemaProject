package src;

public abstract class ColdDrink implements Concessions {

	@Override
	public abstract float price();

	@Override
	public Item item() {
		return new Food();
	}

}
