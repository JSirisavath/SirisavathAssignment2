package driverPackage;


// This will be a sub item to the Pizza class
public class Topping extends Pizza{
	private String extraToppingName;
	private Integer extraToppingQuantity;

	
	// Constructor 
	public Topping(String extraToppingName, String PizzaName, Integer NumberOfPizza, Integer extraToppingQuantity) {
		super(PizzaName,NumberOfPizza); // passing in the pizza name and number of pizza to parent constructor
		this.extraToppingName = extraToppingName;
		this.extraToppingQuantity = extraToppingQuantity;
	}


	public String getExtraToppingName() {
		return extraToppingName;
	}


	public void setExtraToppingName(String extraToppingName) {
		this.extraToppingName = extraToppingName;
	}


	public Integer getExtraToppingQuantity() {
		return extraToppingQuantity;
	}


	public void setExtraToppingQuantity(Integer extraToppingQuantity) {
		this.extraToppingQuantity = extraToppingQuantity;
	}


	@Override
	public String toString() {
		return super.toString() + "\t" + extraToppingName + "\t" + extraToppingQuantity + "\n";
	}


	public boolean equals(Topping toppingParam) {
		if (!super.equals(toppingParam)) {
			return false;
		}
		return this.extraToppingQuantity.equals(toppingParam.extraToppingQuantity);
	}
	
}
