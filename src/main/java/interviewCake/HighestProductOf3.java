package interviewCake;

public class HighestProductOf3 {
	public static int highestProductOf3(int[] intArray) {

		if (intArray.length <3)
			throw new IllegalArgumentException("Atleast 3 items required.");

		int lowest = Math.min(intArray[0], intArray[1]);
		int highest = Math.max(intArray[0], intArray[1]);
		int highestProductOf2 = intArray[0] * intArray[1];
		int lowestProductOf2 =  intArray[0] * intArray[1];
		int highestProductOf3 = Integer.MIN_VALUE;


		for(int i=2;i<intArray.length;i++){
			int current = intArray[i];

			//Update highestProductOf3
			highestProductOf3 = Math.max(
							highestProductOf3,
							Math.max(current * highestProductOf2,
											current * lowestProductOf2)
			);

			highestProductOf2 = Math.max(
							highestProductOf2,
							Math.max(current * highest,
											current * lowest)
			);

			lowestProductOf2 = Math.min(
							lowestProductOf2,
							Math.min(current * highest,
											current * lowest)
			);

			highest = Math.max(current, highest);
			lowest = Math.min(current, lowest);

		}

		return highestProductOf3;
	}
}
