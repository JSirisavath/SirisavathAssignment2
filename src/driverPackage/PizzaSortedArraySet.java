package driverPackage;

public class PizzaSortedArraySet {
	private Pizza[] pizzaAry;
	
	private Integer max;
	
	private Integer arraySize;


	public PizzaSortedArraySet(Integer max) {
		this.max = max;
		
		// Creating the collection class array based on the max input
		this.pizzaAry = new Pizza[max];
		
		
		this.arraySize = 0; // Keep track of elements in array
	}
	
	
	public void insert (Pizza pizza) {
		
		 if (arraySize == pizzaAry.length) {
	            return; // Set is full
	        }

	        // Check for duplicates
	        for (int i = 0; i < arraySize; i++) {
	            if (pizzaAry[i].equals(pizza)) {
	                return; // Duplicate found
	            }
	        }

	        // Find the correct insertion point
	        int insertIndex = 0;
	        while (insertIndex < arraySize && pizzaAry[insertIndex].compareTo(pizza) < 0) {
	            insertIndex++;
	        }

	        // Shift elements to the right to make space for the new element
	        for (int j = arraySize; j > insertIndex; j--) {
	        	pizzaAry[j] = pizzaAry[j - 1];
	        }

	        // Insert the new pizza
	        pizzaAry[insertIndex] = pizza;
	        arraySize++;
	        return;
	}
	
	
	// getting array size
	public int size() {
		return arraySize;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		for (int i = 0; i < arraySize; i++) {
			string.append(pizzaAry[i]).append("\n");
		}
		
		return string.toString();
	}

	
	
	public int indexOf(Pizza pizza) {
		for (int i = 0; i < arraySize; i++) {
			if(pizzaAry[i].equals(pizza)) {
				return i;
			}
		}
		// item not found
		return -1;
	}
	
	
	public boolean remove(Pizza pizza) {
		int index = indexOf(pizza);
		
		// not found
		if (index ==-1) {
			return false;
		}
		
		System.arraycopy(pizzaAry, index +1, pizzaAry, index, arraySize - index -1);
		
		pizzaAry[arraySize-1] = null; // null last 
		
		arraySize--;
		return true;
	}
	
	
	public Pizza grab(int index) {
		return pizzaAry[index];
	}
	
	
	public PizzaSortedArraySet categorySet (int type) {
		// return null if type is not 1-3
		if (type <1 || type >3) {
			return null;
		}
		
		PizzaSortedArraySet categoryArr = new PizzaSortedArraySet(arraySize);
		
		for (int i = 0; i < arraySize; i++) {
			if((type == 1 && pizzaAry[i] instanceof Topping) || 
			(type == 2 && pizzaAry[i] instanceof StuffedCrust) ||
			(type == 3 && !(pizzaAry[i] instanceof Topping || pizzaAry[i] instanceof StuffedCrust))) {
				categoryArr.insert(pizzaAry[i]);
			}
			
		}
		
		return categoryArr;
	}
}


