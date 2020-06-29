package interviewCake;

/**
 * XOR processing Find unique items
 * A^A = 0
 * 0^A = A
 */
public class BitwiseUniqueDeliveryId {

	public static int findUniqueDeliveryId(int[] deliveryIds) {
		int result=0;

		if (deliveryIds.length==0) return 0;
		if (deliveryIds.length==1) return deliveryIds[0];

		for (int i=0; i<deliveryIds.length;i++){
			result = result^deliveryIds[i];
		}

		return result;
	}
}
