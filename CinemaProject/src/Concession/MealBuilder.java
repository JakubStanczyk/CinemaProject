package Concession;




public class MealBuilder {
	private static String drinkType;
	private static String foodType;
	private static String drink;
	private static String flavour;
	private static double drinkPrice;
	private static double foodPrice;
	private static double mealPrice;
	
	public MealBuilder(String foodType, String flavour, String drinkType, String drink, double mealPrice) {
		MealBuilder.foodType = foodType;
		MealBuilder.flavour = flavour;
		MealBuilder.drinkType = drinkType;
		MealBuilder.drink = drink;
		MealBuilder.mealPrice = mealPrice;
		System.out.println(foodType + flavour + drinkType + drink + mealPrice);
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
		return new MealBuilder(foodType,flavour,drinkType, drink,mealPrice);
	}
	
	public String getMeal() {
		return foodType+","+flavour+","+drinkType+","+drink;
	}

	public String getFoodType() {
		return foodType;
	}
	
	public String getFlavour() {
		return flavour;
	}
	
	public String getDrinkType() {
		return drinkType;
	}
	
	public String getDrink() {
		return drink;
	}
	
	public Double getMealPrice() {
		return mealPrice;
	}
}