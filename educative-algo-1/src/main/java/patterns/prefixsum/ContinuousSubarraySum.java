package patterns.prefixsum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
*Problem Statement (LeetCode 523 – Continuous Subarray Sum)Given an integer array nums and an integer k,
* return true if there exists a contiguous subarray whose sum is a multiple of k (i.e., sum % k == 0),
* and the subarray has at least 2 elements. Return false otherwise.Key ConstraintsThe subarray must have length ≥ 2
Sum can be any multiple of k (including 0, ±k, ±2k, etc.)
k is non-zero (guaranteed by problem)
nums[i] can be positive, negative, or zero

Examplesnums = [23, 2, 4, 6, 7], k = 6 → true
Subarray [2, 4] → sum = 6 → 6 % 6 == 0
nums = [23, 2, 6, 4, 7], k = 6 → true
Subarray [23, 2, 6, 4, 7] → sum = 42 → 42 % 6 == 0
nums = [5, 0, 0, 0], k = 3 → true
Subarray [0, 0] → sum = 0 → 0 % 3 == 0
nums = [1, 0], k = 2 → false
Possible subarrays: [1] (len=1), [0] (len=1), [1,0] sum=1 (1%2≠0)

* */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int [] nums, int k) {
        Objects.requireNonNull(nums);
        if (nums.length < 2) return false;

        // K : remainder, V : earliestIndex
        Map<Integer,Integer> remainderToIndex = new HashMap<>();
        remainderToIndex.put(0,-1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Handle negative modulo correctly (Java % can be negative)
            int remainder  = prefixSum % k ;
            if (remainder <0) remainder += k;

            // Check if we've seen this remainder before
            if(remainderToIndex.containsKey(remainder)) {
                int prevIdx =  remainderToIndex.get(remainder);
                if (i - prevIdx >=2) return  true;
            } else{
                remainderToIndex.put(remainder,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum sol  = new ContinuousSubarraySum();
        System.out.println(sol.checkSubarraySum(new int[]{23,2,4,6,6}, 7));   // true
//        System.out.println(sol.checkSubarraySum(new int[]{23,2,6,4,7}, 6));   // true
//        System.out.println(sol.checkSubarraySum(new int[]{5,0,0,0}, 3));      // true
//        System.out.println(sol.checkSubarraySum(new int[]{1,0}, 2));          // false
//        System.out.println(sol.checkSubarraySum(new int[]{1,2,12}, 6));       // true ([2,12])
//        System.out.println(sol.checkSubarraySum(new int[]{0,0}, 1));           // true

    }
}
