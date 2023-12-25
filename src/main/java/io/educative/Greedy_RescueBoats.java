package io.educative;

import java.util.*;
/**
 * Statement
 * A big ship with numerous passengers is sinking, and there is a need to evacuate these people with the minimum number
 * of life-saving boats. Each boat can carry, at most, two persons however, the weight of the people cannot exceed the
 * carrying weight limit of the boat.
 *
 * We are given an array, people, where people[i] is the weight of the ith person, and an infinite number of boats,
 * where each boat can carry a maximum weight, limit. Each boat carries, at most, two people at the same time.
 * This is provided that the sum of the weight of these people is under or equal to the weight limit.
 *
 * You need to return the minimum number of boats to carry all persons in the array.
 *
 * Steps:
 * 1 Sort the people array so that the lightest person is at the start of the array and the heaviest person is at the
 *   end of the array.
 * 2 Initialize two pointers— left at the start and right at the end of the array.
 * 3 Iterate over the people array and check if the combined weight of the lightest and heaviest person is under the
 *   weight limit. If it is, then increment the left pointer and decrement the right pointer.
 * 4 Otherwise, rescue the heaviest person alone and decrement the right pointer.
 * 5 Increment the number of boats.
 * 6 Return the number of boats.
 *
 * The time complexity of the function “rescueBoats” is O(n log n), where n is the length of the “people” array.
 * This is because the function uses the built-in Java function “Arrays.sort” which has a time complexity of O(n log n)
 * to sort the “people” array. The while loop in the function has a time complexity of O(n) as it iterates through the
 * array. Therefore, the overall time complexity is dominated by the sorting operation.
 *
 * The space complexity of the function “rescueBoats” is O(1) because it uses a constant amount of extra space.
 * The space complexity of the built-in Java function “Arrays.sort” is O(log n) because it uses a recursive algorithm
 * to sort the array. The space complexity of the function “twoPointers” is also O(1) because it uses a constant amount
 * of extra space.
 */

public class Greedy_RescueBoats{
    public static int rescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j = people.length-1;
        int numBoats=0;

//        while(i<=j){
//            if ((people[i] + people[j])>limit){
//                numBoats++;
//                j--;
//            }
//            else if ((people[i] + people[j])<=limit){
//                numBoats++;
//                i++;
//                j--;
//            }
//        }
        while(i<=j){
            if ((people[i] + people[j])<=limit){
                i++;
            }
            numBoats++;
            j--;
        }
        return numBoats;
    }
}
