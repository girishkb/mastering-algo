package patterns.slidingwindow;


import java.util.Arrays;

/*
* You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

* */
public class MaximumAverageSubarray {


    public double findMaxAverage(int[] nums, int k){

        if (nums == null || nums.length < k || k <=0 )   {
            throw new IllegalArgumentException("Invalid input or window size.");
        }

        double currentwindoSum = 0;
        for (int i = 0; i < k; i++) {
            currentwindoSum += nums[i];
        }
        double maxSum = currentwindoSum;
        for (int i = k; i < nums.length; i++) {
            currentwindoSum+= nums[i] - nums[i-k];
            maxSum = Math.max(currentwindoSum,maxSum);
        }
        return (double) maxSum /k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray t = new MaximumAverageSubarray();
        int[] n1 = {1,12,-5,-6,50,3};
        int k1 = 4;
        System.out.println( "Array::"+ Arrays.toString(n1) + " K:: " + k1+" Result:::" + t.findMaxAverage(n1,k1));

    }
}
