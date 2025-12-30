package patterns.prefixsum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

 /*
 * Problem Statement
Given an integer array nums and an integer k, return the total number of contiguous subarrays whose sum equals k.
Examples nums = [1, 1, 1], k = 2 → Output: 2
Subarrays: [1,1] (indices 0-1) and [1,1] (indices 1-2)
nums = [1, 2, 3], k = 3 → Output: 2
Subarrays: [1,2] and [3]
nums = [1, -1, 0], k = 0 → Output: 3
Subarrays: the valid ones are [1,-1], [1,-1,0], and [0]


 * */
public class SubarraySumEqualsK {

    public  int subArraySum(int[] nums, int k){
        Objects.requireNonNull(nums,"Array cannot be null");

        // Key: prefixSum, Value: frequency (how many times this prefix sum has occurred)
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1); // Base case.


        int count = 0;
        int prefixSum = 0 ;
        for(int i = 0; i <  nums.length; i++) {
            prefixSum += nums[i];
            int target  = prefixSum - k;

            count += prefixSumCount.getOrDefault(target,0);

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum,0)+1);
        }
        return  count;
    }

    public static void main(String[] args) {
        int[] arr = {23,2,4,6,7};
        int k = 6;
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int result = subarraySumEqualsK.subArraySum(arr,k);
        System.out.println("SubarraySumEquals for k " + k + " result :::" + result);
    }
}
