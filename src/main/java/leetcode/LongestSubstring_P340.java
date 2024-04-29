package leetcode;

import java.util.*;

public class LongestSubstring_P340 {
    /**
     *
     * 340. Longest Substring with At Most K Distinct Characters
     * Pattern: https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems/
     *
     * Input: s = "eceba", k = 2
     * Output: 3
     * Explanation: The substring is "ece" with length 3.
     *
     * Input: s = "aa", k = 1
     * Output: 2
     * Explanation: The substring is "aa" with length 2.
     */

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start=0;
        int end=0;
        int counter=0;
        int maxlen=-1;

        Map<Character,Integer> freq = new HashMap<>();

        while(end<s.length()){
            // Increase counter if the element is not seen or count 0 (i.e element does not exist in map)
            if(!freq.containsKey(s.charAt(end)) || freq.get(s.charAt(end))==0) counter++;
            freq.compute(s.charAt(end), (kk,v)-> v==null?1:v+1);
            end++;
            while(counter>k){
                // reduce counter when oly once instance of element present in map.
                if (freq.get(s.charAt(start))==1) counter--;
                freq.compute(s.charAt(start), (kk, v)->v-1);
                start++;
            }
            maxlen = Math.max(maxlen, end-start);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 3, Output: " + lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println("Expected: 2, Output: " + lengthOfLongestSubstringKDistinct("aa",1 ));

    }
}
