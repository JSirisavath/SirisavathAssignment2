package driverPackage;


// NOTE: The original Pizza class is from my assignment 1 and copied over to here for use of this assignment 2
public class Pizza implements Comparable<Pizza>{

		private String PizzaName;
		
		private Integer NumberOfPizza;

		
		// Constructor for Pizza Name and number of Pizza
		public Pizza(String pizzaName, Integer numberOfPizza) {
			this.PizzaName = pizzaName;
			this.NumberOfPizza = numberOfPizza;
		}
		

		// Getters and Setters
		public String getPizzaName() {
			return PizzaName;
		}


		public void setPizzaName(String pizzaName) {
			PizzaName = pizzaName;
		}


		public Integer getNumberOfPizza() {
			return NumberOfPizza;
		}


		public void setNumberOfPizza(Integer numberOfPizza) {
			NumberOfPizza = numberOfPizza;
		}


		// To string function 
		@Override
		public String toString() {
			return PizzaName + " " + NumberOfPizza;
		}
		
		
		
		// Adding comparable method to sort
		// Returns 0 if equal, "-" value if less than, and "+" value if greater than
		@Override
		public int compareTo(Pizza pizza) {
			
			// This pizza
			String thisCurrentPizza = this.PizzaName.toLowerCase();
			
			int thisCurrentNumberOfPizza = this.NumberOfPizza;
			
			// Users passed in pizza class
			String usersPassedInPizza = pizza.PizzaName.toLowerCase();
			
			int usersNumberOfPizzas = pizza.NumberOfPizza;
			
			
			// compare pizza names case insensitive
			int pizzaCompare = thisCurrentPizza.compareTo(usersPassedInPizza);
			
			// If colors are not the same, this returns a positive or negative value
			if (pizzaCompare !=0) {
				return pizzaCompare;
			}
			
			// if colors are the same, compare number of pizza, and if they are equal then return 0, else return the positive or negative value
			if (thisCurrentNumberOfPizza == usersNumberOfPizzas) {
				return 0;
			} else {
				return Integer.compare(thisCurrentNumberOfPizza, usersNumberOfPizzas);
			}
		
		}
		
		
	}
