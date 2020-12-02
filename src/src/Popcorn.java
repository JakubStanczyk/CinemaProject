package src;

public abstract class Popcorn implements Concessions {

	@Override
	public abstract float price();

	@Override
	public Item item() {
		return new Food();
	}

}
