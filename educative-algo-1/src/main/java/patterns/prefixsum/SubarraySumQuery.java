package patterns.prefixsum;

import java.util.Objects;

/*
* 1. Sum of a Specific Subarray (Range Query)
To find the sum of elements between a specific start index i and end index j (inclusive), the most efficient approach is to use a prefix sum array.
1.Prefix Sum Array: Pre-calculate an array where each element P[k] stores the sum of all elements from the beginning of the original array up to index k.
2. Calculation: The sum of the subarray from i to j is P[j] - P[i-1] (or P[j] if i is 0). This allows you to find any subarray sum in O(1) time after an initial O(n) pre-computation
*
*
*  * A utility class for efficient range sum queries on an immutable array
 * using prefix sums. Preprocessing is O(n), each query is O(1).
 *
 * This is the industry-standard approach for problems requiring multiple
 * subarray sum queries (e.g., in competitive programming, data processing pipelines,
 * or analytics systems).
*/
public class SubarraySumQuery {

    private final long[] prefixSum;

    public SubarraySumQuery(int[] nums){
        Objects.requireNonNull(nums,"Input array cannot be null");
        prefixSum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i]+ nums[i];
        }
    }

    public long query(int startIdx, int endIdx){
        if (startIdx < 0 || endIdx <0 || startIdx >= prefixSum.length-1 ||  endIdx >= prefixSum.length-1 || startIdx > endIdx){
            throw  new IllegalArgumentException(String.format(
                    "Invalid  indices start=%d, end=%d, arr length = %d",
                    startIdx, endIdx, prefixSum.length-1
            ));
        }
        return prefixSum[endIdx+1] - prefixSum[startIdx];
    }

    public static void main(String[] args) throws Exception {

        int[] arr = {1,2,5,7,10,22,8,4,11};
        SubarraySumQuery sumQuery  = new SubarraySumQuery(arr);
        int startIdx = 3, endIdx = 7;
        long result= sumQuery.query(startIdx,endIdx);
        System.out.printf("Sub Array sum from index %d to  %d  Result: %d\n",startIdx,endIdx, result);

        // Additional edge cases
        System.out.println("Full sum : " + sumQuery.query(0,arr.length-1)); //70
        System.out.println("Single element (index 0): " + sumQuery.query(0, 0)); // 1
        System.out.println("Single element (index 5): " + sumQuery.query(5, 5)); // 22


        int[] negativeArr = {-5, 3, -2, 8};
        SubarraySumQuery negQuery = new SubarraySumQuery(negativeArr);
        System.out.println("Sum with negatives: " + negQuery.query(0, 3)); // 4

    }
}
