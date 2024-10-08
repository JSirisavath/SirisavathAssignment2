package driverPackage;


// Given, in example method to add from the directions (Part 2- implement ItemB subclass): public ItemB( String s, Integer n1, Boolean n2 ) 
// Confused since, in the directions, n2 is given as an integer for itemB subclass, but is INIT as a boolean?
// n2 is NOT a integer, but a boolean. So is it meant to be itemA subclass that is n2? If so, then this method wouldn't make sense as to where I need to add an additional variable for the integer variable of this subclass
public class StuffedCrust extends Pizza {
	
	// can make current pizza stuffed crust
	private Boolean StuffedCrust;
	private Integer CheeseQuantityToAdd; // how many cheese added (1-3) ( This is added to compensate for the confusing directions)
	
	
	public StuffedCrust(String PizzaName, Integer NumberOfPizza, Boolean StuffedCrust, Integer CheeseQuantityToAdd) {
		super(PizzaName, NumberOfPizza); // Initialize parent class attribute
		
		this.StuffedCrust = StuffedCrust;
		
		this.CheeseQuantityToAdd = CheeseQuantityToAdd;
	
	}


	public Boolean getStuffedCrust() {
		return StuffedCrust;
	}


	public void setStuffedCrust(Boolean stuffedCrust) {
		StuffedCrust = stuffedCrust;
	}


	public Integer getCheeseQuantityToAdd() {
		return CheeseQuantityToAdd;
	}


	public void setCheeseQuantityToAdd(Integer cheeseQuantityToAdd) {
		CheeseQuantityToAdd = cheeseQuantityToAdd;
	}


	@Override
	public String toString() {
		return super.toString() + "\t" + StuffedCrust + "\t" + CheeseQuantityToAdd + "\n";
	}
	
	
	
	public boolean equals(StuffedCrust stuffedCrustParam) {
		
		// Return false if this current object super (this) does not equal to the stuff crust parameter 
		if (!super.equals(stuffedCrustParam)) {
			return false;
		}
		// evaluate if this is equal to stuffed crust parameter boolean
		return this.StuffedCrust.equals(stuffedCrustParam.StuffedCrust);
	}

}
