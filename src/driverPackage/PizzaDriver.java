package driverPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PizzaDriver {

	public static void main(String[] args) {
		
		// testing the compare method
//		Pizza p1 = new Pizza("Chicago Deep-Dish Pizza", 5);
//		Pizza p2 = new Pizza("New York-style Pizza", 10);
//		Pizza p3 = new Pizza("Detroit-style Pizza", 10);
		
//		System.out.print(p1.compareTo(p2));
//		
//		
//		System.out.print(p3.compareTo(p2));
//				
//		System.out.print(p3.compareTo(p3)); // Should return value 0
		
		
		// NOTE: Eclipse IDE is weird in running this program and not finding the file name. 
//		For this to work, make sure to run the program through run configurations, and then change the workspace to this project "src" - Email me and I can send you a video recording on how to do this via eclipseIDE

		// Test file
		// String fileName = "Pizzas.txt";
        // File file = new File(fileName);
		
		// Try with resources
        try (Scanner userInput = new Scanner(System.in)) {
			System.out.print("Enter the name of file: ");
			String userFileName = userInput.nextLine();
			
			// Create new file from users file name
			File newUserFile = new File(userFileName); // For this example, type in "Pizzas.txt" or add the new file with your data in the SRC directory first
			
			PizzaSortedArraySet pizzaResturant = new PizzaSortedArraySet(20);
			
			//helper method to load the pizza file
			loadPizzasFile(newUserFile, pizzaResturant);
			
			
			System.out.print("Sorted and not duplicated pizza list (Duplicates shown, Not working :( ):\n");
			System.out.println(pizzaResturant);
		}
		
	}

	public static void loadPizzasFile(File newUserFile, PizzaSortedArraySet pizzaResturant) {
		// Try with resources
				try (Scanner scanner = new Scanner(newUserFile)) {
					while (scanner.hasNextLine()) {
						// helper method
						processFile(scanner.nextLine(), pizzaResturant);
						
					}
				} catch (FileNotFoundException e) {
					// Make sure to run it with configuration and select this project root, which is SRC. SRC has the file text
					System.out.println("File not found and error thrown: " + e.getMessage());
				}
		
	}

	public static void processFile(String nextLine, PizzaSortedArraySet pizzaResturant) {
		String cleanLines = nextLine.split("//")[0].trim();
		String[] differentParts = cleanLines.split("\t");
		int type = Integer.parseInt(differentParts[0]);
		String PizzaName = differentParts[1];
		int NumberOfPizza;
		
		
		NumberOfPizza = Integer.parseInt(differentParts[2]);
		switch (type) {
		// Toping subclass
		case 1: 
			String extraToppingName = differentParts[3];
			
			int extraToppingQuantity = Integer.parseInt(differentParts[4]);
			
			Topping topping = new Topping(extraToppingName, PizzaName, NumberOfPizza, extraToppingQuantity);
//			System.out.print(type + " " + topping);
			pizzaResturant.insert(topping);
			break;
			
		// Stuffed Crust subclass
		case 2: 
			Boolean isStuffedCrust = Boolean.parseBoolean(differentParts[3]);
			int cheeseQuantityToAdd = Integer.parseInt(differentParts[4]);
			
			StuffedCrust stuffedCrust = new StuffedCrust(PizzaName, NumberOfPizza, isStuffedCrust, cheeseQuantityToAdd);
//			System.out.print(type + " " + stuffedCrust);
			pizzaResturant.insert(stuffedCrust);
			break;
			
		// Pizza 
		case 3: 
			Pizza pizza = new Pizza(PizzaName, NumberOfPizza);
//			System.out.print(type + " "  +  pizza + "\n");
			pizzaResturant.insert(pizza);
			break;
			
		}
		
	}

}
