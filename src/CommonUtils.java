
/**
 * 
 * Single list of all util methods that can be used
 * @author Saurav
 *
 */
public class CommonUtils {

	public static void displayExecutionTime(long startTime) {
		long finishTime = System.currentTimeMillis();
		double elapsedTime = (finishTime - startTime) / 100;
		System.out.println("\nExcecution time : " + elapsedTime + " seconds");
	}
}
