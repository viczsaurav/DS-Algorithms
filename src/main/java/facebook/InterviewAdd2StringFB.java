package facebook;

public class InterviewAdd2StringFB {
	/**
	 * input:
	 * "1234"
	 *   "11"
	 *
	 *  Add 2 input string (very long). Full string cannot be converted to number but a single digit can
	 */


	public static String addString(String s1, String s2){

		if (s1==null || s2==null)  return null;
		if (s1.length()==0)  return s2;
		if (s2.length()==0) return s1;

		int i= s1.length()-1;
		int j= s2.length()-1;


		StringBuffer out = new StringBuffer();
		int sum=0, carry=0;
		while(i>=0 || j>=0){
			int val1=0, val2=0;
			if(i>=0){
				val1 = Character.digit(s1.charAt(i),10);
			}
			else {
				val1=0;
			}

			if(j>=0){
				val2 = Character.digit(s2.charAt(j),10);
			}
			else {
				val2=0;
			}

			sum = val1 + val2 + carry;
			carry = sum/10;

			out.append(sum%10);

			i--;
			j--;
		}

		if (carry>0){
			out.append(carry);
		}
		return out.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "9734";
		String s2 = "539";

		System.out.println("Expected : [\"10273\"], Actual: " + addString(s1, s2));
	}
}
