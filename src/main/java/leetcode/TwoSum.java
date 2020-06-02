package leetcode;

import java.util.*;
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> comp = new HashMap<>();

		for (int i=0; i<nums.length;i++){
			if (comp.containsKey(nums[i])){
				return (new int[]{comp.get(nums[i]),i});
			}
			comp.put(target-nums[i],i);
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[] input =  new int[]{7,15,11,12,2};
		int target = 9;
		System.out.println(twoSum(input, target));
	}
}
