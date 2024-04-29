package leetcode;
import java.util.*;

class CombinationSum_backtrack_P39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        findSum(candidates, target, result,0, 0, new ArrayList<Integer>());
        return result;
    }

    private static void findSum(int[] candidates, int target, List<List<Integer>> result, int idx, int sum, List<Integer> sublist){

        System.out.println(sublist);
        System.out.println(sum);
        System.out.println(idx);

        // Break condition
        if (sum >=target){
            if (sum==target){
                result.add(sublist);
            }
            return;
        }

        //Iterate
        for (int i=idx; i< candidates.length;i++){
            if (sum + candidates[i]<= target){
                sum = sum + candidates[i];
                sublist.add(candidates[i]);
                findSum(candidates, target, result, i, sum, sublist);
                sum = sum - candidates[idx];
                sublist.remove(sublist.size()-1);
            }
            else {
                sum = sum - candidates[i-1];
                sublist.remove(sublist.size()-1);
                findSum(candidates, target, result, i, sum, sublist);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 5};
        int target1 = 8;
        combinationSum(candidates1, target1);
    }
}
