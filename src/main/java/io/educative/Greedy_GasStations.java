package io.educative;

import java.util.*;


/**
 * Statement
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * We have a car with an unlimited gas tank, and it costs cost[i] of gas to travel from the ith station to the next (i+1)th station.
 * We begin the journey with an empty tank at one of the gas stations.
 *
 * Find the index of the gas station in the integer array gas such that if we start from that index we may return to the
 * same index by traversing through all the elements, collecting gas[i] and consuming cost[i].
 *        If it is not possible, return -1.
 *        If there exists such index, it is guaranteed to be unique.
 *
 * Constraints:
 *
 * gas.length == cost.length
 *
 *
 * Solution summary
 * To recap, the solution to this problem can be divided into the following three parts:
 * 1. If the sum of all values in the gas array is less than the sum of all values in the cost array, we return -1,
 *    because there will be no gas station from which we can start our journey to complete the round trip.
 *
 * 2. Traverse the gas list with startingIndex initially set to 0.
 * 3. We calculate currentGas left by incrementing currentGas (initially 0 at the starting point) to (gas[i] - cost[i]).
 *
 * 4. If at any point, our currentGas is less than 0, it means we can not start from this index. Therefore, we increment
 *    startingIndex to i+1 and reset currentGas to 0.
 *
 * 5. Return startingIndex at the end of the traversal.
 *
 * Time complexity
 * The time complexity is O(n) since there are n elements in the array and we only visit each element once.
 *
 * Space complexity
 * The space complexity is O(1) since we don’t use any additional data structures.
 */

public class Greedy_GasStations{
    public static int gasStationJourney(int[] gas, int[] cost) {

        int costSum=0;
        int gasSum=0;
        int length = gas.length-1;

        for (int i: cost) {  costSum += i;  }
        for (int i: gas)  {   gasSum += i;  }
        if (costSum>gasSum)  return -1;

        int runCost = 0;
        int startidx = 0;

        for (int i=0;i<length;i++){
            runCost = runCost + gas[i] - cost[i];
            if (runCost<0) {
                runCost = 0;
                startidx = i +1;
            }
        }
        return startidx;
    }
}
