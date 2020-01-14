package interviewCake;

public class CafeOrderChecker {

	/**
	 * My cake shop is so popular, I'm adding some tables and hiring wait staff so folks can have a cute sit-down cake-eating experience.
	 *
	 * I have two registers: one for take-out orders, and the other for the other folks eating inside the cafe. All the customer orders get combined into one list for the kitchen, where they should be handled first-come, first-served.
	 *
	 * Recently, some customers have been complaining that people who placed orders after them are getting their food first. Yikes—that's not good for business!
	 *
	 * To investigate their claims, one afternoon I sat behind the registers with my laptop and recorded:
	 *
	 * The take-out orders as they were entered into the system and given to the kitchen. (takeOutOrders)
	 * The dine-in orders as they were entered into the system and given to the kitchen. (dineInOrders)
	 * Each customer order (from either register) as it was finished by the kitchen. (servedOrders)
	 * Given all three arrays, write a method to check that my service is first-come, first-served. All food should come out in the same order customers requested it.
	 *
	 * We'll represent each customer order as a unique integer.
	 *
	 * As an example,
	 *
	 *   Take Out Orders: [1, 3, 5]
	 *  Dine In Orders: [2, 4, 6]
	 *   Served Orders: [1, 2, 4, 6, 5, 3]
	 * would not be first-come, first-served, since order 3 was requested before order 5 but order 5 was served first.
	 *
	 * But,
	 *
	 *   Take Out Orders: [1, 3, 5]
	 *  Dine In Orders: [2, 4, 6]
	 *   Served Orders: [1, 2, 3, 5, 4, 6]
	 * would be first-come, first-served.
	 *
	 */

	/**
	 * Approach to start from servedOrders, O(n) time and O(1) space
	 * @param takeOutOrders
	 * @param dineInOrders
	 * @param servedOrders
	 * @return
	 */
	public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
		int takeOutOrdersIndex = 0;
		int dineInOrdersIndex = 0;

		for (int order : servedOrders) {

			/*
			 * if we still have orders in takeOutOrders and the current order in takeOutOrders
			 * is the same as the current order in servedOrders
			 */
			if (takeOutOrdersIndex < takeOutOrders.length && order == takeOutOrders[takeOutOrdersIndex]) {
				takeOutOrdersIndex++;

			 /** If we still have orders in dineInOrders and the current order in dineInOrder
				* is the same as the current order in servedOrders
			  */
			} else if (dineInOrdersIndex < dineInOrders.length && order == dineInOrders[dineInOrdersIndex]) {
				dineInOrdersIndex++;

			/** if the current order in servedOrders doesn't match the current order in takeOutOrders or
			 * dineInOrders,then we're not serving first-come, first-served
			 */
			} else {
				return false;
			}
		}

		// check for any extra orders at the end of takeOutOrders or dineInOrders
		if (dineInOrdersIndex != dineInOrders.length || takeOutOrdersIndex != takeOutOrders.length) {
			return false;
		}

		// all orders in servedOrders have been "accounted for"
		// so we're serving first-come, first-served!
		return true;
	}

	/**
	 * In place check : O(n) time and O(1) space
	 * @param takeOutOrders
	 * @param dineInOrders
	 * @param servedOrders
	 * @return
	 */
	public static boolean isFirstComeFirstServedApproach(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

		// takeOutOrders + dineInOrders = servedOrders
		if(takeOutOrders.length+dineInOrders.length != servedOrders.length){
			return false;
		}

		int takeOutOrdersIdx=0;
		int dineInOrdersIdx=0;
		int servedOrdersIdx=0;

		while(servedOrdersIdx<servedOrders.length){
			boolean isTakeOutOrdersCompleted = (takeOutOrdersIdx>=takeOutOrders.length);
			boolean isDineInOrdersCompleted = (dineInOrdersIdx>=dineInOrders.length);

			if(!isTakeOutOrdersCompleted && (isDineInOrdersCompleted ||
							takeOutOrders[takeOutOrdersIdx]<=dineInOrders[dineInOrdersIdx])){
				if(servedOrders[servedOrdersIdx]!=takeOutOrders[takeOutOrdersIdx]){
					return false;
				}
				takeOutOrdersIdx++;
			}
			else {
				if(servedOrders[servedOrdersIdx]!=dineInOrders[dineInOrdersIdx]){
					return false;
				}
				dineInOrdersIdx++;
			}
			servedOrdersIdx++;
		}
		return true;
	}

	/**
	 * New array creation : O(n) time and O(n) space
	 * @param takeOutOrders
	 * @param dineInOrders
	 * @param servedOrders
	 * @return
	 */
	public static boolean isFirstComeFirstServedSpace(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

		// takeOutOrders + dineInOrders = servedOrders
		if(takeOutOrders.length+dineInOrders.length != servedOrders.length){
			return false;
		}

		// Merge takeOutOrders and dineInOrders
		int[] mergedOrders = mergeOrderedArrays(takeOutOrders,dineInOrders);

		// Compare with servedOrders
		for(int i=0;i<servedOrders.length;i++){
			if(mergedOrders[i]!=servedOrders[i]){
				return false;
			}
		}
		return true;
	}

	public static int[] mergeOrderedArrays(int[] arr1, int[] arr2){

		int[] mergedArray = new int[arr1.length+arr2.length];

		int arr1Index=0;
		int arr2Index=0;
		int mergedArrayIndex=0;

		while(mergedArrayIndex<mergedArray.length){
			boolean isArr1Completed = (arr1Index>=arr1.length);
			boolean isArr2Completed = (arr2Index>=arr2.length);

			if(!isArr1Completed && (isArr2Completed ||
							arr1[arr1Index]<=arr2[arr2Index])){
				mergedArray[mergedArrayIndex] = arr1[arr1Index];
				arr1Index++;
			}
			else {
				mergedArray[mergedArrayIndex] = arr2[arr2Index];
				arr2Index++;
			}
			mergedArrayIndex++;
		}
		return mergedArray;
	}
}