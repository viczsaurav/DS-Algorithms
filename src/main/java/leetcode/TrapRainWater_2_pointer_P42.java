package leetcode;
import java.util.*;

class TrapRainWater_2_pointer_P42 {
    // Try with O(N) storage => Store maxleft, maxright and different in seprate arrays.
    public int trap(int[] height) {
        int n = height.length;
        int [] maxLeft = new int[n];
        int [] maxRight =  new int[n];
        int total=0;

        maxLeft[0] = 0;
        maxRight[n-1] = 0;

        //Fill maxLeft array moving from left=> right
        for(int i=1; i<n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        //Fill maxRight array moving from right=> left
        for(int j=n-2; j>0;j--){
            maxRight[j] =  Math.max(maxRight[j+1], height[j+1]);
        }


        for (int i=0; i<n; i++){
            int curr = Math.max(0, Math.min(maxLeft[i],maxRight[i])- height[i]);
            total +=curr;
        }
        return total;

    }

    // This one is with O(1) storage => 2 pointer
    public int trap_in_O_1(int[] height) {
        int left = 0, right =  height.length-1;
        int maxleft = height[left];
        int maxright = height[right];

        int total =0;

        while(left<right){
            // Shift left pointer
            if(maxleft<maxright){
                left++;
                maxleft = Math.max(maxleft, height[left]);
                // ideally it won't be negative as we have updated maxleft in previous step
                total += Math.max(0, maxleft-height[left]);
            }
            // Shift right pointer
            else {
                right--;
                maxright = Math.max(maxright, height[right]);
                total += Math.max(0, maxright-height[right]);

            }
        }
        return total;
    }
}
