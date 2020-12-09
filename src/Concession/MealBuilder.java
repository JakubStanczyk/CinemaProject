package Concession;

public class MealBuilder {
	private static String drinkType;
	private static String foodType;
	private static String drink;
	private static String flavour;
	private static float drinkPrice;
	private static float foodPrice;
	private static float mealPrice;
	
	public MealBuilder(String drinkType, String foodType, String drink, String flavour, float mealPrice) {
	}

	public MealBuilder drinkType(String drinkType) {
		MealBuilder.drinkType = drinkType;
		return this;
	}
	
	public MealBuilder foodType(String foodType) {
		MealBuilder.foodType = foodType;
		return this;
	}
	
	public MealBuilder drink(String drink) {
		MealBuilder.drink = drink;
		return this;
	}
	
	public MealBuilder flavour(String flavour) {
		MealBuilder.flavour = flavour;
		return this;
	}
	
	public MealBuilder drinkPrice(float drinkPrice) {
		MealBuilder.drinkPrice = drinkPrice;	
		return this;
	}
	
	
	public MealBuilder foodPrice(float foodPrice) {
		MealBuilder.foodPrice = foodPrice;
		return this;
	}
	
	public MealBuilder buildMeal() {
		MealBuilder.mealPrice = drinkPrice + foodPrice;
		return new MealBuilder(drinkType,foodType,drink, flavour,mealPrice);
		
	}
}
