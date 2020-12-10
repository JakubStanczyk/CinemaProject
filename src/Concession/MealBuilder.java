package Concession;

public class MealBuilder {
	private static String drinkType;
	private static String foodType;
	private static String drink;
	private static String flavour;
	private static double drinkPrice;
	private static double foodPrice;
	private static double mealPrice;
	
	public MealBuilder(String drinkType, String foodType, String drink, String flavour, double mealPrice) {
		MealBuilder.drinkType = drinkType;
		MealBuilder.foodType = foodType;
		MealBuilder.drink = drink;
		MealBuilder.flavour = flavour;
		MealBuilder.mealPrice = mealPrice;
		System.out.println(drinkType + drink + foodType + flavour + mealPrice);
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
	
	public MealBuilder drinkPrice(double drinkPrice) {
		MealBuilder.drinkPrice = drinkPrice;	
		return this;
	}
	
	
	public MealBuilder foodPrice(double foodPrice) {
		MealBuilder.foodPrice = foodPrice;
		return this;
	}
	
	public MealBuilder buildMeal() {
		MealBuilder.mealPrice = drinkPrice + foodPrice;
		return new MealBuilder(drinkType,foodType,drink, flavour,mealPrice);
		
	}
}
