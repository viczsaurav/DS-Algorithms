package facebook;
import java.util.*;

public class RotationalCipher{


	String rotationalCipher(String input, int rotationFactor) {
		StringBuffer buffer = new StringBuffer();

		// rotationFactor will be different for digit (%10) and alphabets(%26)

		for(int i=0;i<input.length();i++){
			char ch = input.charAt(i);

			// If character is digit
			if (Character.isDigit(ch)){
				ch = Character.forDigit((Character.getNumericValue(ch) + rotationFactor%10)%10,10);
			}
			else if (Character.isLetter(ch)){
				int start = Character.isUpperCase(ch)? (int)('A'):(int)('a');
				ch = (char)(((int)ch - start + rotationFactor%26)%26 + start);
			}
			buffer.append(ch);
		}
		return buffer.toString();

	}


	int test_case_number = 1;
	void check(String expected, String output) {
		boolean result = (expected.equals(output));
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printString(expected);
			System.out.print(" Your output: ");
			printString(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printString(String str) {
		System.out.print("[\"" + str + "\"]");
	}

	public void run() {
		String input_1 = "All-convoYs-9-be:Alert1.";
		int rotationFactor_1 = 4;
		String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
		String output_1 = rotationalCipher(input_1, rotationFactor_1);
		check(expected_1, output_1);

		String input_2 = "abcdZXYzxy-999.@";
		int rotationFactor_2 = 200;
		String expected_2 = "stuvRPQrpq-999.@";
		String output_2 = rotationalCipher(input_2, rotationFactor_2);
		check(expected_2, output_2);

		String input_3 = "Zebra-493?";
		int rotationFactor_3 = 3;
		String expected_3 = "Cheud-726?";
		String output_3 = rotationalCipher(input_3, rotationFactor_3);
		check(expected_3, output_3);

		String input_4 = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
		int rotationFactor_4 = 39;
		String expected_4 = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
		String output_4 = rotationalCipher(input_4, rotationFactor_4);
		check(expected_4, output_4);

	}

	public static void main(String[] args) {
		new RotationalCipher().run();
	}
}