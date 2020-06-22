package facebook;

class MatchingPairs {

	/**
	 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=559324704673058
	 *
	 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
	 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
	 *
	 * Note: This means you must swap two characters at different indices.
	 * Signature  :  int matchingPairs(String s, String t)
	 * Input
	 * 		s and t are strings of length N
	 * 		N is between 2 and 1,000,000
	 * Output
	 * 		Return an integer denoting the maximum number of matching pairs
	 *
	 * Example 1
	 * 		s = "abcd"
	 * 		t = "adcb"
	 * output = 4
	 * Explanation:
	 * 		Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
	 *
	 */

	int matchingPairs(String s, String t) {
		int count =0, i=0, j=0;

		while(i<s.length() && j<t.length()&& s.charAt(i)==t.charAt(j)){
			i++; j++;
		}

		if (i==s.length()) return (s.length()-2); // Atleast 1 swap is needed

		int temp_i=i+1;
		int temp_j=j+1;

		while (temp_i<s.length()&& temp_j<t.length() && s.charAt(temp_i)==t.charAt(temp_j)){
			temp_i++; temp_j++;
		}

		// Case 1 : Reach till end without any other non-matching char => Atleast 1 swap
		if (temp_i==s.length()) return (s.length()-2);

		// Case 2 : We found other non-matching char
		// Case 2.1 : If swapping makes them same string (Emulatimg Swap - Exact 1 swap)
		if (s.charAt(i)==t.charAt(temp_j) && s.charAt(temp_i)== t.charAt(j)){
			count = temp_i+1;
		}
		// Case 2.1 : If swapping does not make them same string
		else {
			count = temp_i-1; // temp_i+1-2
		}
		i= temp_i+1;
		j=temp_j+1;

		while(i<s.length() && j<t.length()){
			if (s.charAt(i)==t.charAt(j)) {
				count++;
			}
			i++; j++;
		}
		return count;
	}

	int test_case_number = 1;
	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}
	public void run() {
		String s_1 = "abcde";
		String t_1 = "adcbe";
		int expected_1 = 5;
		int output_1 = matchingPairs(s_1, t_1);
		check(expected_1, output_1);

		String s_2 = "abcd";
		String t_2 = "abcd";
		int expected_2 = 2;
		int output_2 = matchingPairs(s_2, t_2);
		check(expected_2, output_2);

		String s_3 = "abcdefg";
		String t_3 = "adcbekg";
		int expected_3 = 6;
		int output_3 = matchingPairs(s_3, t_3);
		check(expected_3, output_3);

		String s_4 = "abcdefg";
		String t_4 = "akcdefg";
		int expected_4 = 5;
		int output_4 = matchingPairs(s_4, t_4);
		check(expected_4, output_4);

		String s_5 = "abcd";
		String t_5 = "abcd";
		int expected_5 = 2;
		int output_5 = matchingPairs(s_5, t_5);
		check(expected_5, output_5);

		String s_6 = "abed";
		String t_6 = "abcd";
		int expected_6 = 2;
		int output_6 = matchingPairs(s_6, t_6);
		check(expected_6, output_6);

	}
	public static void main(String[] args) {
		new MatchingPairs().run();
	}
}
