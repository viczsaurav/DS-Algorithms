package interviewCake;

public class ProductOfAllOtherNumbers {
	/**
	 * You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
	 *
	 * Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
	 *
	 * For example, given:
	 *
	 *   [1, 7, 3, 4]
	 *
	 * your method would return:
	 *
	 *   [84, 12, 28, 21]
	 *
	 * by calculating:
	 *
	 *   [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
	 *
	 * Here's the catch: You can't use division in your solution!
	 *
	 */

	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

		int size = intArray.length;
		if (size<2)
			throw new IllegalArgumentException("At least 2 required");

		int[] productArray = new int[size];
		productArray[0] = 1;

		for(int i=0; i<size-1;i++){
			productArray[i+1] = productArray[i] * intArray[i];
		}

		int productSofar =1;
		for (int i=size-1;i>=0;i--){
			productArray[i] *= productSofar;
			productSofar *= intArray[i];
		}
		return productArray;
	}
}

