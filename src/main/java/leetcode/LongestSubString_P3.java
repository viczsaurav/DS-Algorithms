package leetcode;
import java.util.*;

public class LongestSubString_P3 {
	public int lengthOfLongestSubstring(String s) {
		int max=0;
		int firstPtr=0, secondPtr=0;
		Set<Character> charSet= new HashSet<>();

		while(secondPtr< s.length()){
			if (!charSet.contains(s.charAt(secondPtr))){
				charSet.add(s.charAt(secondPtr));
				secondPtr++;
				max=Math.max(max, secondPtr-firstPtr);
			}
			else{
				charSet.remove(s.charAt(firstPtr));
				firstPtr++;
			}
		}
		return max;
	}
}
