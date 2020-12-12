package Discount;

public class Discount {
	String discountName; 
	double discountPercentage;
	
	public void setdiscountName(String discountName) {
		this.discountName = discountName;
	}
	
	public void setdiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public String getDiscountName() {
		return this.discountName;
	}
	
	public double getDiscountPercentage() {
		return this.discountPercentage;
	}
	
	public String getDiscountPercentageAsString() {
		
		String stringPercentage = String.valueOf(this.discountPercentage);
		
		return stringPercentage;
	}
	
	

}
