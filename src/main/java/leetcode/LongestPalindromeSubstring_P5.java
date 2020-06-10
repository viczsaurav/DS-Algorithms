package leetcode;

public class LongestPalindromeSubstring_P5 {
	public String longestPalindrome(String s) {
		int start=0, end=0;

		for (int i=0; i<s.length();i++){
			int len1 = getPalindromeLength(s,i,i); // Odd Length
			int len2 = getPalindromeLength(s,i,i+1); // Even length

			int len = Math.max(len1, len2);

			/* When len=odd=> i= mid term, thus i = len/2 =>
							start = i - len/2 = i - (len-1)/2 [len/2 and (len-1)/2 gives same result if len is odd]
							end = i + len/2 + 1(add 1 for substring(last index exclusive))
			 * when len=even=> (i, i+1) = mid terms, thus, i+(i+1)=len => i= (len-1)/2
			 * 			start =  i - (len-2)/2 [remove i, (i+1)th terms and then move left from i ] => start = ???
			 * 		  end = (i+1) + (len-2)/2 + 1(add 1 for substring(last index exclusive))=> end =  i + len/2 + 1
			 */
			if (len> end-start){
				start=i-(len-1)/2; // Not Very clear
				end=i+(len/2)+1;	// Not Very clear
			}
		}
		return s.substring(start,end);

	}

	private int getPalindromeLength(String s, int left, int right){
		while(left>=0 && right<=s.length()-1
						&& s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;
	}

	public static void main(String[] args) {
		String str = "cbbd";
		LongestPalindromeSubstring_P5 obj = new LongestPalindromeSubstring_P5();
		System.out.println(obj.longestPalindrome(str));
	}
}
