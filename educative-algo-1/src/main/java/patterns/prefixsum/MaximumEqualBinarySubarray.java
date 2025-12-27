package patterns.prefixsum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.

* */
public class MaximumEqualBinarySubarray {

    public int findMaxLength(int[] nums) {
        Objects.requireNonNull(nums,"Input array cannot be null");
        Map<Integer,Integer> prefixSumToIndex = new HashMap<>();


        // Base case: empty subarray before index 0 has sum 0
        prefixSumToIndex.put(0,-1);

        int prefixSum = 0, maxLength = 0;

        for(int i = 0; i < nums.length; i++) {
            // Update prefix sum: +1 for 1, -1 for 0
            prefixSum += (nums[i] == 1)? 1:-1;

            // If we've seen this prefix sum before, update max length
            if (prefixSumToIndex.containsKey(prefixSum)) {
                int firstOccurrence = prefixSumToIndex.get(prefixSum);
                maxLength = Math.max(maxLength, i- firstOccurrence);
            }else{
                // Store only the first occurrence
                prefixSumToIndex.put(prefixSum,i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,1,0,0,1};
        MaximumEqualBinarySubarray maximumEqualBinarySubarray = new MaximumEqualBinarySubarray();
        System.out.println("Max Length of sub array having equal 0's and 1's " + maximumEqualBinarySubarray.findMaxLength(arr));
    }
}
